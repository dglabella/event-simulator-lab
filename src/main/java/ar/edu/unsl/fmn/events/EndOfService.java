package ar.edu.unsl.fmn.events;

import java.util.List;

import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, Behavior behavior) {
        super(clock, entity, 0, behavior);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = this.getEntity().getServer();
        Entity entity;
        if (!server.queuesEmpty()) {
            /*
            * Aca tengo que hacer:
            * "Despreciar" el que tiene el servidor asociado
            * Asignarle el de tope de cola al server
            * Planificar el proximo EOS para esta entidad que acabo de asignar
            * */
            entity = server.dequeue();//Ver si este dequeue esta trabajando como debe
            //Que deberia ser tomar la cola y devolver el primero que tiene
            //Para esto, la cola deberia tener una entidad cargada dentro
            server.setCurrentEntity(entity);
            double nextTime = this.getBehavior().nextTime();
            fel.insert(new EndOfService(
                    this.getClock() + nextTime,
                    entity,
                    this.getBehavior()));
            double queueTime = this.getClock() - entity.getEvents().get(0).getClock();//esta bien decirle que es el 0?
            entity.getServer().addTotalQueueTime(queueTime);
            entity.getServer().compareMaxQueueTime(queueTime);
            entity.getServer().addTotalServiceTime(nextTime);
            entity.getServer().compareMaxServiceTime(nextTime);


        }
        else{
            //REVISAR SI FALTA ALGO, IDLE TIME?
            server.setCurrentEntity(null);
            entity = null;
        }
        //Coleccion de Estadisticas

    }

    @Override
    public String toString() {
        return "end of service - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
