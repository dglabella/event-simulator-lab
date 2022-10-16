package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.HeavyAirstrip;
import ar.edu.unsl.fmn.resources.LightAirstrip;
import ar.edu.unsl.fmn.resources.Server;

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

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "HeavyAircraft"; //Ver que devuelva bien
    }

    @Override
    public void applyEffect(Server server, double damage){
        if (Airstrip.class.equals(server.getClass())) {
            ((Airstrip) server).updateDurability(damage);
        }
    }
}
