package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.events.EndOfService;
import ar.edu.unsl.fmn.resources.Server;

import java.util.ArrayList;

public class Aircraft extends Entity {

    private double airstripBreak;

    public Aircraft() {
        super();
        airstripBreak = 0;
    }

    public Aircraft(int id) {
        super(id);
        airstripBreak = 0;
    }

    public Aircraft(int id, Arrival arrival) {
        super(id,arrival);
        airstripBreak = 0;
    }

    @Override
    public void applyEffect(Server server, double damage) {

    }

    public double getAirstripBreak() {
        return airstripBreak;
    }

    public void setAirstripBreak(double airstripBreak) {
        this.airstripBreak = airstripBreak;
    }

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }

}
