package ar.edu.unsl.fmn.events;

import java.util.List;

import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.Utils;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, Behavior behavior) {
        super(clock, entity, 0, behavior);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = this.getEntity().getServer();
        Entity entity;
        server.addAircraftAttended();


        double dmg = Utils.calculateDmg(server.getCurrentEntity(), (Airstrip)server);
        server.getCurrentEntity().applyEffect(server,dmg);


        if (!server.queuesEmpty()) {
            entity = server.dequeue();
            server.setCurrentEntity(entity);

            double tickEoS = this.getClock() + this.getBehavior().nextTime(entity,this.getClock()); //RENOMBRAR
            fel.insert(new EndOfService(
                    tickEoS,
                    entity,
                    this.getBehavior()));
            //calculo tiempo de cola
            entity.calculateQueuedTime(this.getClock());
            entity.getServer().addTotalQueueTime(entity.getQueuedTime());
            entity.getServer().compareMaxQueueTime(entity.getQueuedTime());
            //calculo tiempo de servicio
            entity.getServer().addTotalServiceTime(tickEoS - entity.getEvents().get(0).getClock());
            entity.getServer().compareMaxServiceTime(tickEoS - entity.getEvents().get(0).getClock());
        }
        else{
            //REVISAR SI FALTA ALGO, IDLE TIME?
            server.setCurrentEntity(null);
            entity = null;

            server.startIdle(this.getClock());
            //ACA LEVANTO EL FLAG QUE EMPIEZA A ESTAR EN OCIO Y GUARDO ESTE TICK
            //el profe ponia 2 flags en -1
        }
        //Coleccion de Estadisticas

    }

    @Override
    public String toString() {
        return "end of service - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
