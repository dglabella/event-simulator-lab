package ar.edu.unsl.fmn.events;

import java.util.List;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity) {
        super(clock, entity, 0);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {

        Server server = this.getEntity().getServer();
        Entity entity;

        if (!server.queuesEmpty()) {
            entity = server.dequeue();
            server.setCurrentEntity(entity);
        } else {
            server.setCurrentEntity(null);
            entity = null;
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "end of service - entity id: " + this.getEntity().getId() + " - clock: "
                + this.getClock();
        return ret;
    }
}
