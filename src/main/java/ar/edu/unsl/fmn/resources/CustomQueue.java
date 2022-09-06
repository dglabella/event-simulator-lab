package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.entities.Entity;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
