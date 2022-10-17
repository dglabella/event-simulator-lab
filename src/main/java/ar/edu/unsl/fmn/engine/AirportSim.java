package ar.edu.unsl.fmn.engine;

import java.util.List;
import java.util.Scanner;

import ar.edu.unsl.fmn.behaviors.ArrivalBehavior;
import ar.edu.unsl.fmn.behaviors.EndOfServiceBehavior;
import ar.edu.unsl.fmn.entities.*;
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

    private double stopTime;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy, Randomizer randomizer) {
        fel = new FutureEventList();
        this.stopTime = endClock;
        this.servers = servers;
        this.policy = policy;
        fel.insert(new StopSimulation(endClock,this));

        LightAircraft entity1 = new LightAircraft(1);
        MediumAircraft entity2 = new MediumAircraft(1);
        HeavyAircraft entity3 = new HeavyAircraft(1);
        Maintenance entity4 = new Maintenance(1);
        Arrival arrival1 = new Arrival(0,
                entity1,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);
        Arrival arrival2 = new Arrival(0,
                entity2,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);
        Arrival arrival3 = new Arrival(0,
                entity3,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);
        Arrival arrival4 = new Arrival(0,
                entity4,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);

        entity1.getEvents().add(arrival1);
        entity2.getEvents().add(arrival2);
        entity3.getEvents().add(arrival3);
        entity4.getEvents().add(arrival4);
        fel.insert(arrival1);
        fel.insert(arrival2);
        fel.insert(arrival3);
        fel.insert(arrival4);
    }

    @Override
    public void execute() {
        System.out.println(fel.toString());
        while(!stop){
            fel.getImminent().planificate(fel,servers);

            System.out.println("\nexecute in AirportSim: showing fel in every planificate step: \n");
            System.out.println(fel.toString());
        }
    }

    @Override
    public void stopExecute() {
        stop = true;
    }

    @Override
    public void generateReport() {
        //Esto deberia estar asociado a una clase que me guarde las estadisticas y llamar a eso desde aca
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
        /*
        System.out.println("Entidades atendidas: " + this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Total de espera en cola: " + this.policy.selectServer(servers).getTotalQueueTime());
        System.out.println("Tiempo Medio de espera en cola: " + this.policy.selectServer(servers).getTotalQueueTime()/this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Maximo de espera en cola: " + this.policy.selectServer(servers).getMaxQueueTime());
        System.out.println("Tiempo Total de transito: " + this.policy.selectServer(servers).getTotalServiceTime());
        System.out.println("Tiempo Medio de transito: " + this.policy.selectServer(servers).getTotalServiceTime()/this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Maximo de transito: " + this.policy.selectServer(servers).getMaxServiceTime());
        System.out.println("Tiempo Total de ocio de la pista: " + this.policy.selectServer(servers).getIdleTotalTime());
        System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",((this.policy.selectServer(servers).getIdleTotalTime() * 100) / stopTime)) + "%");
        System.out.println("Tiempo maximo de ocio de la pista: " + this.policy.selectServer(servers).getMaxIdleTime());
        System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",((this.policy.selectServer(servers).getMaxIdleTime() * 100) / stopTime)) + "%");
        System.out.println("Tamaño Maximo de la cola de espera para este servidor: " + this.policy.selectServer(servers).getMaxQueue());
         */
    }
}
