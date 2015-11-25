package controllers;

import actors.CmdMessage;
import actors.LogMessage;
import actors.RootActorSystem;
import actors.StatusMessage;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.pattern.AskableActorSelection;
import akka.util.Timeout;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.Files;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import views.html.index;
import views.html.update;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Controller with 4 actions
 * index: show the form
 * update: get form values and update Metadata
 * status: show the status while updating
 * log: write the logs into an csv file
 */
public class Application extends Controller {


    static ActorSystem actorSystem = RootActorSystem.getInstance().getActorSystem();

    /**
     * load previously saved values, fill the form and show template (views/index.scala.html)
     * @return
     */
    public static Result index() {
        File file = new File("cmd.json");
        Form<CmdMessage> cmdForm;
        if (file.exists()) {
            String cmd_json = Files.readFile(file);
            JsonNode json = Json.parse(cmd_json);
            cmdForm = Form.form(CmdMessage.class).bind(json);
        } else {
            cmdForm = Form.form(CmdMessage.class);
        }

        String message ="Please enter your data.";
        return ok(index.render(message, cmdForm));
    }

    /**
     * load the form values, validate them, create a command for the actor system
     * @return
     */
    public static Result update() {
        String result="";
        ActorSelection rootActor = actorSystem.actorSelection("user/RootActor");
        Form<CmdMessage> cmdForm = Form.form(CmdMessage.class).bindFromRequest();

        if (cmdForm.hasErrors()) {
            return badRequest(index.render("Errors", cmdForm));
        }
        CmdMessage resetMsg = new CmdMessage();
        //reset
        resetMsg.update=false;
        resetMsg.reset=true;
        rootActor.tell(resetMsg);
        CmdMessage cmd = cmdForm.get();
        // data is a csv with searchvalue;replacevalue
        BufferedReader bufreader = new BufferedReader(new StringReader(cmd.getData()));
        String line = null;
        try {
            while ((line = bufreader.readLine()) != null) {
                CmdMessage updatecmd = new CmdMessage(cmd);
                List<String> values = Arrays.asList(line.split(";"));
                if (values.size()==2) {
                    updatecmd.setKey(values.get(0));
                    updatecmd.setReplace(values.get(1));
                    updatecmd.update=true;
                    updatecmd.reset=false;
                    rootActor.tell(updatecmd);
                } else {
                    result +=line+" wrong syntax";
                    continue;
                }
            }
            JsonNode jnode = Json.toJson(cmd);
            FileWriter writer = new FileWriter("cmd.json");
            writer.write(jnode.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok(update.render("Updating ...", result));
    }

    /**
     * this action ist called by ajax on updating data.
     * It returns status information in json
     * @return
     */
    public static Result status() {
        ActorSelection statusActor = actorSystem.actorSelection("user/StatusActor");
        CmdMessage cmd = new CmdMessage(false);
        cmd.status = true;
        //rootActor.tell(cmd, ActorRef.noSender());
        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        AskableActorSelection asker = new AskableActorSelection(statusActor);
        Future<Object> future = asker.ask( cmd, timeout);
        ObjectNode result = Json.newObject();
        try {
            StatusMessage status = (StatusMessage) Await.result(future, timeout.duration());
            if (status.getTotal() > 0) {
                result.put("of", status.getTotal());
                result.put("finished", status.getCount());
                float percent = (status.getCount() * 100.0f) / status.getTotal();
                if (status.getTotal() == status.getCount()) {
                    result.put("message"," Worked on "+ status.getCount() + " of " + status.getTotal() + " items!");
                }
                result.put("percent", percent);
            } else {
                result.put("of", status.getTotal());
                result.put("message", "Not working on documents!") ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok(result);
    }

    /**
     * write the logged data into a csv file and return it to the user
     * @return
     */
    public static Result log() {
        ActorSelection statusActor = actorSystem.actorSelection("user/StatusActor");
        CmdMessage cmd = new CmdMessage(false);
        cmd.log=true;
        File file = new File("log.csv");
        if (file.exists()) {
            file.delete();
        }

        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        AskableActorSelection asker = new AskableActorSelection(statusActor);
        Future<Object> future = asker.ask(cmd, timeout);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter("log.csv");
            writer.append("key;replacekey;new value;pid;message\n");
            List<LogMessage> logs = (List<LogMessage>) Await.result(future, timeout.duration());
            for (LogMessage log:logs) {
                writer.append(log.toString()+"\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return ok(new java.io.File("log.csv"));
    }


}
