package actors;

import akka.actor.*;

/**
 * Created by Ott Konstantin on 02.06.2015.
 */
public class RootActor extends UntypedActor {

    static ActorSystem actorSystem = RootActorSystem.getInstance().getActorSystem();


    @Override
    public void onReceive(Object message) throws Exception {
        ActorRef sender = getSender();
        ActorSelection statusActor = actorSystem.actorSelection("user/StatusActor");
        if (message instanceof CmdMessage) {
            CmdMessage cmd = (CmdMessage) message;
            if (cmd.update) {
                statusActor.tell(cmd, getSelf());
                ActorSelection updateActor = actorSystem.actorSelection("user/UpdateActor");
                updateActor.tell(cmd, getSelf());
            } else if (cmd.reset) {
                statusActor.tell(cmd, getSelf());
            }
        }

    }

}
