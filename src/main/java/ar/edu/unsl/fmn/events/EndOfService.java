package ar.edu.unsl.fmn.events;

import java.util.List;

import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.entities.Maintenance;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.Auxiliar;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.Utils;
import sun.tools.jar.Main;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, Behavior behavior) {
        super(clock, entity, 0, behavior);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        Server server = this.getEntity().getServer();
        Entity entity;
        //ESTA LINEA LA COMENTE XQ TIRABA NPE, REVISAR PQ
        server.addEntityAttended();


        //System.out.println(this.getEntity().toString());
        /*if(this.getEntity() instanceof Maintenance){
            System.out.println(this.getEntity().getServer());
        }*/
        //System.out.println(this.getEntity().getServer().toString());
        //System.out.println(server.getClass());


        double dmg = Utils.calculateDmg(this.getEntity(), (Airstrip)server,this.getBehavior().getRandomizer());
        this.getEntity().applyEffect(server,dmg);
        //server.getCurrentEntity().applyEffect(server,dmg);



        if (!server.queuesEmpty()) {
            entity = server.dequeue();
            server.setCurrentEntity(entity);
            entity.setServer(server);

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
