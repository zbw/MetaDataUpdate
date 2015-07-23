package actors;

import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.UntypedActor;
import com.exlibris.core.sdk.formatting.DublinCore;
import com.exlibris.core.sdk.formatting.DublinCoreFactory;
import com.exlibris.dps.IEWebServices;
import com.exlibris.dps.IEWebServices_Service;
import com.exlibris.dps.MetaData;
import com.exlibris.dps.sdk.pds.PdsClient;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import play.libs.XPath;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.BindingProvider;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ott Konstantin on 02.06.2015.
 * this actor does the work
 * it gets the matching ids and updates the value in the metadata
 */
public class UpdateActor extends UntypedActor {

    static ActorSystem actorSystem = RootActorSystem.getInstance().getActorSystem();

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof CmdMessage) {
            //Thread.sleep(100);
            List<LogMessage> logs = updateItem((CmdMessage) message);
            ActorSelection statusActor = actorSystem.actorSelection("user/StatusActor");
            for (LogMessage log:logs) {
                statusActor.tell(log);
            }
        }
    }

    private ArrayList<LogMessage> updateItem(CmdMessage cmd) {
        ArrayList<LogMessage> logs = new ArrayList<LogMessage>();
        List<String> sipIds = getIDs(cmd);
        if (sipIds.size() == 0) {
            LogMessage log = new LogMessage(cmd.getKey(),cmd.getReplacekey(), cmd.getReplace(),"", "not found");
            logs.add(log);
        }
        for (String pid:sipIds) {
            // update IE
            logs.add(updateIE(cmd,pid));
        }
        return logs;
    }

    /**
     * Lookup Rosetta by SRU to fetch the PIDs
     * @param cmd
     * @return
     */
    private ArrayList<String> getIDs(CmdMessage cmd) {
        ArrayList<String> ids = new ArrayList<String>();
        String sru_url = cmd.getSru()
                + cmd.getSearchkey() + "="
                + cmd.getKey();
        try {
            URL url = new URL(sru_url);
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            df.setNamespaceAware(false);
            DocumentBuilder db = df.newDocumentBuilder();
            Document document = db.parse(conn.getInputStream());
            NodeList records = XPath.selectNodes("//recordData", document);
            for (int i=0;i<records.getLength();i++) {
                Node record = records.item(i);
                String pid =XPath.selectText("record/identifier[@type='PID']",record);
                ids.add(pid);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ids;
    }

    /**
     * gets the metadata for the pid, modifies it and sends it back for saving
     * @param cmd
     * @param pid
     * @return
     */
    private LogMessage updateIE(CmdMessage cmd, String pid) {
        LogMessage log = new LogMessage(cmd.getKey(), cmd.getReplacekey(), cmd.getReplace(),pid, "updating");
        PdsClient pds = PdsClient.getInstance();
        try {
            pds.init(cmd.getPds(), false);
            IEWebServices iews = new IEWebServices_Service(new URL( cmd.getEndpoint()+"?wsdl"),new QName("http://dps.exlibris.com/", "IEWebServices")).getIEWebServicesPort();
            BindingProvider ie_bindingProvider = (BindingProvider) iews;
            ie_bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, cmd.getEndpoint());
            String pdsHandle = pds.login(
                    cmd.getInstitution(),
                    cmd.getUserName(),
                    cmd.getPassword());
            String result = iews.getIEMD(pdsHandle, pid);
            String dmc = iews.getMD(pdsHandle,pid);
            String dcXml = getDCXml(result);
            dcXml = replace(dcXml,cmd.getReplacekey(),cmd.getReplacekeyattribute(),cmd.getReplace());
            MetaData md = createMetadata(dcXml);

            ArrayList <MetaData> mds = new ArrayList<MetaData>();
            mds.add(md);
            String ok="ok";
            if (!cmd.testmodus) {
                iews.updateMD(pdsHandle, pid, mds);
            } else {
                ok = "TEST ok";
            }
            log = new LogMessage(cmd.getKey(), cmd.getReplacekey(), cmd.getReplace(),pid, ok);
            //System.out.println(result);
        } catch (Exception e) {
            log = new LogMessage(cmd.getKey(),cmd.getReplacekey(), cmd.getReplace(),pid, e.getMessage());
        }
        return log;
    }


    // some utils coming here

    private String replace(String xml, String replacekey, String attr, String replacevalue) throws Exception {
        Document document = getXMLDocument(xml);
        NodeList nodes = document.getElementsByTagName(replacekey);
        if (nodes.getLength() == 0) {
            throw  new Exception("replace key not found");
        }
        boolean changed = false;
        for (int i = 0; i<nodes.getLength();i++) {
            Element replaceNode = (Element) nodes.item(i);
            if (attr.equals("") && !replaceNode.hasAttributes() ||
                    !attr.equals("") && replaceNode.hasAttribute(attr)) {
                Element newNode = (Element) replaceNode.cloneNode(true);
                newNode.setTextContent(replacevalue);
                replaceNode.getParentNode().appendChild(newNode);
                replaceNode.getParentNode().removeChild(replaceNode);
                changed=true;
            }
        }
        if (!changed) {
            throw  new Exception("replace key attr not found");
        }
        return getStringFromDocument(document);
    }
    private DublinCore getDC(String iexml) throws Exception {
        Document doc = getXMLDocument(iexml);
        String mdWrap = getSection(doc,"//dmdSec//mdWrap");
        Document mdWr = getXMLDocument(mdWrap);
        String record = getSection(mdWr,"//mdWrap//record");
        DublinCore dc = DublinCoreFactory.getInstance().createDocument(record);

        return dc;

    }

    private String getDCXml(String iexml) throws Exception {
        Document doc = getXMLDocument(iexml);
        String mdWrap = getSection(doc,"//dmdSec//mdWrap");
        Document mdWr = getXMLDocument(mdWrap);
        return getSection(mdWr,"//mdWrap//record");
    }

    private Document getXMLDocument(String entity) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputStream is = new ByteArrayInputStream(entity.getBytes("UTF-8"));
        return dBuilder.parse(is);
    }

    private String getSection(Document doc, String expression) throws Exception {
        javax.xml.xpath.XPath xPath =  XPathFactory.newInstance().newXPath();
        StreamResult result = new StreamResult(new StringWriter());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Node node= (Node) xPath.compile(expression).evaluate(doc, XPathConstants.NODE);

        DOMSource source = new DOMSource(node);
        transformer.transform(source, result);
        return result.getWriter().toString();
    }

    private MetaData createMetadata(DublinCore dc) throws IOException {
        MetaData md = new MetaData();
        md.setMid(null);
        md.setContent(dc.toXml());
        md.setType("descriptive");
        md.setSubType("dc");
        return md;
    }

    private MetaData createMetadata(String dcxml) throws IOException {
        MetaData md = new MetaData();
        md.setMid(null);
        md.setContent(dcxml);
        md.setType("descriptive");
        md.setSubType("dc");
        return md;
    }

    public static String getStringFromDocument(Node doc) throws TransformerException {
        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);
        return writer.toString();
    }

}
