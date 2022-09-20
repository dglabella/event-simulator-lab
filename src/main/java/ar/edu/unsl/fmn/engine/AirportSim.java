package ar.edu.unsl.fmn.engine;

import java.util.List;
import java.util.Scanner;

import ar.edu.unsl.fmn.behaviors.ArrivalBehavior;
import ar.edu.unsl.fmn.behaviors.EndOfServiceBehavior;
import ar.edu.unsl.fmn.entities.Aircraft;
import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.events.StopSimulation;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.Randomizer;

public class AirportSim implements Engine {

    private boolean stop = false;

    private FutureEventList fel;
    private List<Server> servers;

    private ServerSelectionPolicy policy;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy, Randomizer randomizer) {
        fel = new FutureEventList();
        this.servers = servers;
        this.policy = policy; //Para el generate report
        fel.insert(new StopSimulation(endClock,this));
        Aircraft entity = new Aircraft(1);
        Arrival arrival = new Arrival(0,
                entity,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);

        entity.getEvents().add(arrival);
        fel.insert(arrival);
        policy.selectServer(servers).addAircraftAttended();

    }

    @Override
    public void execute() {
        System.out.println(fel.toString());
        while(!stop){
            fel.getImminent().planificate(fel,servers);

            System.out.println("\nexecute in AirportSim: showing fel in every planificate step: (borrar este msg?)\n");
            System.out.println(fel.toString());
        }
    }

    @Override
    public void stopExecute() {
        stop = true;
        System.out.println("stopExecute in AirportSim: Method not yet corroborated");
    }

    @Override
    public void generateReport() {
        /*
        * Cantidad total de aeronaves que aterrizaron.
        * Tiempo total de espera en cola.
        * Tiempo medio de espera en cola.
        * Tiempo máximo de espera en cola.
        * Tiempo total de transito.
        * Tiempo medio de tránsito.
        * Tiempo máximo de tránsito.
        * Tiempo total de ocio de la pista y el porcentaje que representa respecto del tiempo de simulación.
        * Tiempo máximo de ocio de la pista y el porcentaje que representa respecto del tiempo total de ocio.
        * Tamaño máximo de la cola de espera para este servidor.
         */

        //Esto tira en un 0, pero deberia saber de que server, por lo que deberia guardar la politica?
        System.out.println("Entidades atendidas: " + policy.selectServer(servers).getAircraftAttended());
        System.out.println("generateReport in AirportSim: Method not yet implemented");
    }
}
