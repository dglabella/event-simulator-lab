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
        Server server = this.getEntity().getServer();
        Entity entity;
        System.out.println("pre-pregunta");
        if(!servers.get(0).queuesEmpty()){ //El 0 en vez de ser 0 no deberia estar determinado por la policy?
            System.out.println("Se hara un dequeue");
            entity = servers.get(0).dequeue();
            servers.get(0).setCurrentEntity(entity);
            System.out.println("Se ingresara un EOS");
            fel.insert(new EndOfService(
                    this.getClock() + this.getBehavior().nextTime(),
                    entity,
                    this.getBehavior()));
            System.out.println("Se ingreso un EOS");
            System.out.println(fel.toString());
        }
        else{
            server.setCurrentEntity(null);
            entity = null;
        }
        //Comentado por si estoy consultando bien la cola o no
        /*System.out.println("EOS Pre-Pregunta");
        if (!server.queuesEmpty()) {
            System.out.println("Se hara un dequeue");
            entity = server.dequeue();
            server.setCurrentEntity(entity);
            System.out.println("Se ingresara un EOS");
            fel.insert(new EndOfService(
                    this.getClock() + this.getBehavior().nextTime(),
                    entity,
                    this.getBehavior()));
            System.out.println("Se ingreso un EOS");
            System.out.println(fel.toString());
        } else {
            System.out.println("rama del else");
            server.setCurrentEntity(null);
            entity = null;
        }*/
        System.out.println("EndOfSerice planificate fuera if/else");
        //ver si colecciono estadisticas
    }

    @Override
    public String toString() {
        return "end of service - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
