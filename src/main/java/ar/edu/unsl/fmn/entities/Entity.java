package ar.edu.unsl.fmn.entities;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.events.Event;
import ar.edu.unsl.fmn.resources.Server;

public abstract class Entity {

    private int id;

    private Server server;

    private List<Event> events;

    private double queuedTime;

    public Entity() {}

    public Entity(int id) {
        this.id = id;
        events = new ArrayList<>();
        this.queuedTime = 0;
    }

    public Entity(int id, Arrival arrival) {
        this.events = new ArrayList<>();
        this.id = id;
        this.events.add(arrival);
        this.queuedTime = 0;
    }

    /*public Entity(int id, EndOfService endOfService) {
        this.events = new ArrayList<>();

        this.id = id;
        this.events.add(endOfService);
    }

    public Entity(int id, StopSimulation stopSimulation) {
        this.events = new ArrayList<>();

        this.id = id;
        this.events.add(stopSimulation);
    }*/

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Server getServer() {
        return this.server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public List<Event> getEvents() {
        return this.events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public double getQueuedTime(){
        return this.queuedTime;
    }

    private void setQueuedTime(double queuedTime){
        this.queuedTime = queuedTime;
    }

    public void calculateQueuedTime(double currentTime){
        setQueuedTime(currentTime - getEvents().get(0).getClock());
    }

    public abstract void applyEffect(Server server);
}
