import actors.RootActor;
import actors.RootActorSystem;
import actors.StatusActor;
import actors.UpdateActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import play.Application;
import play.GlobalSettings;
import play.Logger;

/**
 * Created by Ott Konstantin on 02.06.2015.
 */
public class Global extends GlobalSettings {

    static ActorSystem actorSystem = RootActorSystem.getInstance().getActorSystem();
    static {
        actorSystem.actorOf(Props.create(RootActor.class), "RootActor");
        actorSystem.actorOf(Props.create(UpdateActor.class), "UpdateActor");
        actorSystem.actorOf(Props.create(StatusActor.class), "StatusActor");
    }

    @Override
    public void onStart(Application app) {
        Logger.info("Application has started");
    }
}
