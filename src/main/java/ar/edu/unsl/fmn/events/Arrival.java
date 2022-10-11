package ar.edu.unsl.fmn.events;

import java.util.List;
import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.behaviors.EndOfServiceBehavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Aircraft;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.Utils;

public class Arrival extends Event {

    private ServerSelectionPolicy policy;

    private EndOfServiceBehavior endOfServiceBehavior;

    public Arrival(double clock, Entity entity, Behavior behavior,
            EndOfServiceBehavior endOfServiceBehavior, ServerSelectionPolicy policy) {
        super(clock, entity, 2, behavior);
        this.policy = policy;
        this.endOfServiceBehavior = endOfServiceBehavior;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = this.policy.selectServer(servers, this.getEntity());
        if(server.isBusy()){
            server.enqueue(this.getEntity());
        }
        else{
            server.setCurrentEntity(this.getEntity());
            //aca desgasto la pista
            //si es mantenimiento arreglar
            //PARA LOS DOS::
            //cuando creo la entidad o algo asi, le digo cuanto va a desgastar (negativo) o le digo
            //cuanto voy a sumar si es mantenimiento (un switch por tipo de pista y va aser positivo)
            //y le hago la suma a server.desgastar(entity.getdesgasste)
            //settear el desgaste en la creacion de la entity

            this.getEntity().setServer(server);
            double eosclock = this.getClock() + endOfServiceBehavior.nextTime(); //RENOMBRAR
            fel.insert(new EndOfService(
                    eosclock,
                    this.getEntity(),
                    this.endOfServiceBehavior));
            this.getEntity().getServer().addTotalServiceTime(eosclock - this.getEntity().getEvents().get(0).getClock());
            this.getEntity().getServer().compareMaxServiceTime(eosclock - this.getEntity().getEvents().get(0).getClock());
            //IdleTime
            this.getEntity().getServer().endIdle(this.getClock());
        }
        //Planifico proximo arribo:
        System.out.println("Ver pq aca mete un aircraft y no veo que tipo deberia ser");
        System.out.println("linea 60, mandale, del arrival, la parte de planificar prox arribo xd");
        Aircraft aircraft = new Aircraft(this.getEntity().getId() +1);
        Arrival arrival = new Arrival(this.getClock() + this.getBehavior().nextTime(),aircraft,this.getBehavior(),endOfServiceBehavior,policy);
        aircraft.getEvents().add(arrival);
        aircraft.setServer(this.policy.selectServer(servers, aircraft));

        fel.insert(arrival);
        //Colleccionar datos
        //this.policy.selectServer(servers).addAircraftAttended();
    }

    @Override
    public String toString() {
        return "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
