package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.entities.Entity;

public interface Queue {

    int getId();

    boolean isEmpty();

    void enqueue(Entity entity);

    Entity checkNext();

    Entity next();
}
