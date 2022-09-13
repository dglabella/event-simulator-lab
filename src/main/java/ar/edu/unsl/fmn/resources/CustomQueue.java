package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.entities.Entity;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void enqueue(Entity entity) {
        this.queue.add(entity);
    }

    @Override
    public Entity checkNext() {
        return this.queue.peek();
    }

    @Override
    public Entity next() {
        return this.queue.remove();
    }
}
