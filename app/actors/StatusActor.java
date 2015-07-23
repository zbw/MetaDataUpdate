package actors;

import akka.actor.UntypedActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ott Konstantin on 03.06.2015.
 * this actor collects status info and returns the logs
 */
public class StatusActor extends UntypedActor {

    private List<LogMessage> logs = new ArrayList();
    private int entered=0;
    private int finished=0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof CmdMessage) {
            CmdMessage cmd = (CmdMessage) message;
            if (cmd.reset) {
                entered = 0;
                finished = 0;
                logs = new ArrayList();
            }  else if (cmd.update) {
                entered++;
            }  else if (cmd.status) {
                StatusMessage status = new StatusMessage();
                status.setCount(finished);
                status.setTotal(entered);
                getSender().tell(status, getSelf());
            }  else if (cmd.log) {
               getSender().tell(logs,getSelf());
            }
        } else if (message instanceof LogMessage) {
            LogMessage log = (LogMessage) message;
            logs.add(log);
            finished ++;

        }
    }
}
