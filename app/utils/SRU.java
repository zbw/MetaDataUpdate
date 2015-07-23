package utils;

import org.dom4j.Document;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ott Konstantin on 05.06.2015.
 */
public class SRU {

    private int count;
    private List<Node> nodelist;

    public SRU(Document document) {
        Node recordcount = document.selectSingleNode("//srw:numberOfRecords");
        if (recordcount != null) {
            count = Integer.parseInt(recordcount.getText());
        }
        if (count == 0) {
            nodelist = new ArrayList<Node>();
        } else {
            nodelist = document.selectNodes("//srw:recordData") ;
        }
    }
}
