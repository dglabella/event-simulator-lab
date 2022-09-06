package ar.edu.unsl.fmn.events;

import java.util.List;
import ar.edu.unsl.fmn.behaviors.Behavior;
import ar.edu.unsl.fmn.engine.FutureEventList;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Server;

public abstract class Event {

    private double clock;
    private Entity entity;
    private int order;

    private Behavior behavior;

    public Event(double clock, Entity entity, int order, Behavior behavior) {}

    public double getClock() {
        return this.clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Behavior getBehavior() {
        return this.behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public abstract void planificate(FutureEventList fel, List<Server> servers);
}
