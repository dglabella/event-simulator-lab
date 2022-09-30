package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class HeavyAircraft extends Aircraft{

    public HeavyAircraft(){
        super();
    }

    public HeavyAircraft(int id) {
        super(id);
    }

    public HeavyAircraft(int id, Arrival arrival) {
        super(id,arrival);
    }
}
