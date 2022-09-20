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

public class Arrival extends Event {

    private ServerSelectionPolicy policy;

    private EndOfServiceBehavior endOfServiceBehavior;

    public Arrival(double clock, Entity entity, Behavior behavior,
            EndOfServiceBehavior endOfServiceBehavior, ServerSelectionPolicy policy) {
        super(clock, entity, 0, behavior);
        this.policy = policy;
        this.endOfServiceBehavior = endOfServiceBehavior;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = this.policy.selectServer(servers);
        if(server.isBusy()){
            server.enqueue(this.getEntity());
            //REVISAR SI LE HACE EL ENQUEUE BIEN
        }
        else{
            server.setCurrentEntity(this.getEntity());
            this.getEntity().setServer(server);

            fel.insert(new EndOfService(
                    this.getClock() + endOfServiceBehavior.nextTime(),
                    this.getEntity(),
                    this.endOfServiceBehavior));
        }
        //Planifico proximo arribo:
        Aircraft aircraft = new Aircraft(this.getEntity().getId() +1);
        Arrival arrival = new Arrival(this.getClock() + this.getBehavior().nextTime(),aircraft,this.getBehavior(),endOfServiceBehavior,policy);
        aircraft.getEvents().add(arrival);
        //LE FALTABA ESTO DE ABAJO?????
        aircraft.setServer(this.policy.selectServer(servers));

        fel.insert(arrival);
        //Colleccionar datos
        this.policy.selectServer(servers).addAircraftAttended();
    }

    @Override
    public String toString() {
        return "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
    }
}
