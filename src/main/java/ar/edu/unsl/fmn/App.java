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
import ar.edu.unsl.fmn.utils.distributions.Normal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private static final double SIMULATION_LENGHT = 40320d;
    // private static final double SIMULATION_LENGHT = 100d;

    public static void main(String[] args) {
        Normal normal = new Normal(120, 100);
        Random random = new Random(0);

        for (int i = 0; i < 50; i++) {
            System.out.println(normal.event());
        }

        System.out.println("=========================================================");

        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextGaussian() * 10 + 120);
        }

        // para saber lo de hora pico hago modulo de cuantos minutos sean 24hs y si el arribo esta
        // entre
        // ese tiempo de hora pico le mando otra exponential

         Engine engine = new AirportSim( SIMULATION_LENGHT, ScenarioBuilder.OneServerOneQueue(),
         new UniqueServerSelectionPolicy(), new CustomRandomizer()); engine.execute();
         engine.generateReport();

    }
}
