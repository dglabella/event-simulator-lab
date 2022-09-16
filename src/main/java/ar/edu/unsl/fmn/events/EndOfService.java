package ar.edu.unsl.fmn.events;

import java.util.List;

import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, Behavior behavior) {
        super(clock, entity, 0, behavior);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        System.out.println("prueba1");
        Server server = this.getEntity().getServer();
        System.out.println("prueba2");
        Entity entity;

        if (!server.queuesEmpty()) {
            entity = server.dequeue();
            server.setCurrentEntity(entity);
        } else {
            server.setCurrentEntity(null);
            entity = null;
        }
        System.out.println("EndOfSerice planificate fuera if/else");
        //ver si colecciono estadisticas
    }

    @Override
    public String toString() {
        return "end of service - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
