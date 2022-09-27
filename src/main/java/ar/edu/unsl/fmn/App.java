package ar.edu.unsl.fmn;

import ar.edu.unsl.fmn.engine.AirportSim;
import ar.edu.unsl.fmn.engine.Engine;
import ar.edu.unsl.fmn.policies.OneToOneServerQueue;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;
import ar.edu.unsl.fmn.policies.UniqueServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.CustomQueue;
import ar.edu.unsl.fmn.resources.Queue;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.ScenarioBuilder;
import ar.edu.unsl.fmn.utils.distributions.Exponential;


import java.util.ArrayList;
import java.util.List;

public class App {

    private static final double SIMULATION_LENGHT = 40320d;
    //private static final double SIMULATION_LENGHT = 100d;

    public static void main(String[] args) {
        Exponential asd = new Exponential(1/5d);
        System.out.println(asd.event(0.6321235));

        //para saber lo de hora pico hago modulo de cuantos minutos sean 24hs y si el arribo esta entre
        //ese tiempo de hora pico le mando otra exponential
        /*Engine engine = new AirportSim(
                SIMULATION_LENGHT,
                ScenarioBuilder.OneServerOneQueue(),
                new UniqueServerSelectionPolicy(),
                new CustomRandomizer());
        engine.execute();
        engine.generateReport();*/
    }
}
