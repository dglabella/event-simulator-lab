package ar.edu.unsl.fmn.events;

import java.util.List;
import ar.edu.unsl.fmn.engine.AirportSim;
import ar.edu.unsl.fmn.engine.Engine;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Server;

public class StopSimulation extends Event {

    private Engine engine;

    public StopSimulation(double clock, AirportSim engine) {
        super(clock ,null, 1, null);
        this.engine = engine;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers) {
        engine.stopExecute();
    }

    @Override
    public String toString() {
        return "Stop Simulation - entity id: null - clock: " + this.getClock();
    }
}
