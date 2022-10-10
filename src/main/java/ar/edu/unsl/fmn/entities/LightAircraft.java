package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class LightAircraft extends Aircraft{
    public LightAircraft(){
        super();

    }

    public LightAircraft(int id, double breakRatio) {
        super(id);
        setAirstripBreak(breakRatio);
    }

    public LightAircraft(int id, Arrival arrival, double breakRatio) {
        super(id,arrival);
        setAirstripBreak(breakRatio);
    }
}
