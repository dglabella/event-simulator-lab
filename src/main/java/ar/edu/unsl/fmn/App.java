package ar.edu.unsl.fmn;

import ar.edu.unsl.fmn.engine.AirportSim;
import ar.edu.unsl.fmn.engine.Engine;
import ar.edu.unsl.fmn.policies.MultipleServerSelectionPolicy;
import ar.edu.unsl.fmn.policies.OneToOneServerQueue;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;
import ar.edu.unsl.fmn.policies.UniqueServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.CustomQueue;
import ar.edu.unsl.fmn.resources.Queue;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.ScenarioBuilder;
import ar.edu.unsl.fmn.utils.Statistics;
import ar.edu.unsl.fmn.utils.distributions.Exponential;
import ar.edu.unsl.fmn.utils.distributions.Normal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private static final double SIMULATION_LENGHT = 40320d;
    private static final int SIMULATION_RUNS = 50;

    public static void main(String[] args) {

        /*Statistics stats;

        Engine engine = new AirportSim( SIMULATION_LENGHT, ScenarioBuilder.MultipleServersOneQueuePerServer(),
                new MultipleServerSelectionPolicy(), new CustomRandomizer());
        engine.execute();
        stats = engine.getStatistics();
        engine.generateReport(stats);*/

        Statistics[] stats = new Statistics[SIMULATION_RUNS];
        for(int i=0;i<SIMULATION_RUNS;i++){
            Engine engine = new AirportSim( SIMULATION_LENGHT, ScenarioBuilder.MultipleServersOneQueuePerServer(),
                    new MultipleServerSelectionPolicy(), new CustomRandomizer());
            engine.execute();
            stats[i] = engine.getStatistics();
            engine.generateReport(stats[i]);
        }

        /**
         * Hacer algo con estas stats[i]
         * intervalos de confianza
         * (convulucion)
         */
    }
}
