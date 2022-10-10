package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.LightAirstrip;
import ar.edu.unsl.fmn.resources.MediumAirstrip;
import ar.edu.unsl.fmn.resources.Server;

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

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "MediumAircraft"; //Ver que devuelva bien
    }

    @Override
    public void applyEffect(Server server, double damage){
        if (Airstrip.class.equals(server.getClass())) {
            ((Airstrip) server).updateDurability(damage);
        }
    }
}
