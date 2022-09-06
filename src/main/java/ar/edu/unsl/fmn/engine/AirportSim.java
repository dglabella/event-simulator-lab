package ar.edu.unsl.fmn.engine;

import java.util.List;
import java.util.Scanner;
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

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
            Randomizer randomizer) {}

    @Override
    public void execute() {
        //start
    }

    @Override
    public void stopExecute() {
        //frenada por ev fin
    }

    @Override
    public void generateReport() {
        //mostrar recolecciones
    }
}
