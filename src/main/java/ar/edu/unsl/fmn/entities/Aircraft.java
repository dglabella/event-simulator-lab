package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;

public class Aircraft extends Entity {

    public Aircraft() {
        super();
    }

    public Aircraft(int id) {
        super(id);
    }

    public Aircraft(int id, Arrival arrival) {
        super(id);
    }

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
