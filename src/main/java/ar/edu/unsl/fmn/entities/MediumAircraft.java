package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class MediumAircraft extends Aircraft{
    public MediumAircraft(){
        super();
    }

    public MediumAircraft(int id) {
        super(id);
    }

    public MediumAircraft(int id, Arrival arrival) {
        super(id,arrival);
    }
}
