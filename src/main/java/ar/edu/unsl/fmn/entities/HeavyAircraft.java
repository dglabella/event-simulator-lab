package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class HeavyAircraft extends Aircraft{

    public HeavyAircraft(){
        super();
    }

    public HeavyAircraft(int id, double breakRatio) {
        super(id);
        setAirstripBreak(breakRatio);
    }

    public HeavyAircraft(int id, Arrival arrival, double breakRatio) {
        super(id,arrival);
        setAirstripBreak(breakRatio);
    }
}
