package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class LightAircraft extends Aircraft{
    public LightAircraft(){
        super();
    }

    public LightAircraft(int id) {
        super(id);
    }

    public LightAircraft(int id, Arrival arrival) {
        super(id,arrival);
    }
}
