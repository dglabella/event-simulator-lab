package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class MediumAircraft extends Aircraft{
    public MediumAircraft(){
        super();
    }

    public MediumAircraft(int id, double breakRatio) {
        super(id);
        setAirstripBreak(breakRatio);
    }

    public MediumAircraft(int id, Arrival arrival, double breakRatio) {
        super(id,arrival);
        setAirstripBreak(breakRatio);
    }
}
