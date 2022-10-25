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
import ar.edu.unsl.fmn.utils.Statistics;
import ar.edu.unsl.fmn.utils.distributions.Normal;

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
        Normal norm = new Normal(5,Math.pow(0.5,2));
        Arrival arrival4 = new Arrival(norm.event() * 1440d, //Para que no entre un mant en tiempo 0
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
        //System.out.println(fel.toString());
        while(!stop){
            fel.getImminent().planificate(fel,servers);
            //System.out.println("\nexecute in AirportSim: showing fel in every planificate step: \n");
            //System.out.println(fel.toString());
        }
    }

    @Override
    public void stopExecute() {
        stop = true;
    }

    @Override
    public void generateReport(Statistics statistics) {
        System.out.println(fel.toString());
        statistics.showReport();
    }

    @Override
    public Statistics getStatistics() {
        Statistics statistics = new Statistics(servers, stopTime);
        statistics.collectStatistics(servers);
        return statistics;
    }
}
