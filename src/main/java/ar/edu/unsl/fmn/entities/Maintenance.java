package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.resources.Server;
import com.sun.org.apache.xpath.internal.operations.Equals;

public class Maintenance extends Entity{

    public Maintenance() {
        super();
    }

    public Maintenance(int id) {
        super(id);
    }

    public Maintenance(int id, Arrival arrival) {
        super(id,arrival);
    }

    @Override
    public void applyEffect(Server server) {

    }

    @Override
    public String toString() {
        return "type: maintenance - id: " + this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "Maintenance"; //Ver que devuelva bien
    }
}
