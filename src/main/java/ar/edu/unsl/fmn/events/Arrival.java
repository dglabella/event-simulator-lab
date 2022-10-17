package ar.edu.unsl.fmn.events;

import java.util.List;
import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.behaviors.EndOfServiceBehavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.HeavyAirstrip;
import ar.edu.unsl.fmn.resources.LightAirstrip;
import ar.edu.unsl.fmn.resources.MediumAirstrip;
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
            System.out.println("Clase del servidor a la que se hace enqueue:");
            System.out.println(server.toString());
            System.out.println("Aircraft que se mete en la cola:");
            System.out.println(this.getEntity().toString());
            System.out.println("se procede al enqueue");
            server.enqueue(this.getEntity());
        }
        else{
            server.setCurrentEntity(this.getEntity());
            this.getEntity().setServer(server);
            double eosclock = this.getClock() + endOfServiceBehavior.nextTime(this.getEntity(), this.getClock()); //RENOMBRAR
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
        Entity aircraft;
        int instance = 0;
        if(this.getEntity() instanceof LightAircraft){
            instance = 1;
        } else if (this.getEntity() instanceof MediumAircraft) {
            instance = 2;
        } else if (this.getEntity() instanceof HeavyAircraft) {
            instance = 3;
        } else if (this.getEntity() instanceof Maintenance) {
            instance = 4;
        }
        switch (instance){
            case 1:
                aircraft = new LightAircraft(this.getEntity().getId() +1);
                break;
            case 2:
                aircraft = new MediumAircraft(this.getEntity().getId() +1);
                break;
            case 3:
                aircraft = new HeavyAircraft(this.getEntity().getId() +1);
                break;
            case 4:
                aircraft = new Maintenance(this.getEntity().getId() +1);
                break;
            default:
                System.out.println("Default on Arrival should never be reached");
                aircraft = new Aircraft(this.getEntity().getId() +1);
                break;
        }



        //Aircraft aircraft = new Aircraft(this.getEntity().getId() +1);
        Arrival arrival = new Arrival(this.getClock() + this.getBehavior().nextTime(aircraft,this.getClock()),aircraft,this.getBehavior(),endOfServiceBehavior,policy);
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
