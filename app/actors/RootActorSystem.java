package actors;

import akka.actor.ActorSystem;

/**
 * Created by Ott Konstantin on 02.06.2015.
 * this is the global Actorsystem
 */
public class RootActorSystem {

    static ActorSystem actorSystem = ActorSystem.create("zbwMDUpdateSystem");
    private static RootActorSystem instance = new RootActorSystem();



    private RootActorSystem() {
    }

    public static RootActorSystem getInstance() {
        return instance;
    }

    public ActorSystem getActorSystem() {
        return actorSystem;
    }
}
