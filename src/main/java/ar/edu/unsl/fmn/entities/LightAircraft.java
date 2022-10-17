package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.LightAirstrip;
import ar.edu.unsl.fmn.resources.Server;

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

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "LightAircraft"; //Ver que devuelva bien
    }

    @Override
    public void applyEffect(Server server, double damage){
        ((Airstrip) server).updateDurability(damage);
    }

    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: light";

        return ret;
    }
}
