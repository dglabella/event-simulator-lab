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


import java.util.ArrayList;
import java.util.List;

public class App {

    private static final double SIMULATION_LENGHT = 40320d;

    public static void main(String[] args) {
        //Inicializacion
        Engine engine = new AirportSim(
                SIMULATION_LENGHT,
                ScenarioBuilder.OneServerOneQueue(),
                new UniqueServerSelectionPolicy(),
                new CustomRandomizer());

        //Arrival y EOS tienen mismo order en el constructor, se trataba primero la salida y despues la entrada?
        engine.execute();
        engine.generateReport();
    }
}
