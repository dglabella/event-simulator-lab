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

import java.util.ArrayList;
import java.util.List;

public class App {

    private static final float SIMULATION_LENGHT = 40320f;

    public static void main(String[] args) {
        //Inicializacion
        List<Queue> queues = new ArrayList<>();
        queues.add(new CustomQueue());

        List<Server> airstrips = new ArrayList<>();
        airstrips.add(new Airstrip(0,queues,new OneToOneServerQueue()));

        Engine engine = new AirportSim(
                SIMULATION_LENGHT,
                airstrips,
                new UniqueServerSelectionPolicy(),
                new CustomRandomizer());

        engine.execute();
        engine.generateReport();
    }
}
