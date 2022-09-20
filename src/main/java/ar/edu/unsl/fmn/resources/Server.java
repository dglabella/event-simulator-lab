package ar.edu.unsl.fmn.resources;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public abstract class Server {

    private int id;

    private Entity currentEntity;

    private List<Queue> queues;

    private ServerQueuePolicy policy;

    private int aircraftAttended;

    public Server() {

    }

    public Server(int id, List<Queue> queues, ServerQueuePolicy policy) {
        this.id = id;
        this.queues = queues;
        this.policy = policy;
        this.aircraftAttended=0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity getCurrentEntity() {
        return this.currentEntity;
    }

    public void setCurrentEntity(Entity currentEntity) {
        this.currentEntity = currentEntity;
    }

    public int getAircraftAttended(){return this.aircraftAttended;}

    public void addAircraftAttended(){
        this.aircraftAttended += 1;
    }

    public boolean isBusy() {
        return this.currentEntity == null ? false : true;
    }

    public boolean queuesEmpty() {
        return this.policy.queuesEmpty(this.queues);
        //return this.queues.isEmpty();
    }

    public void enqueue(Entity entity) {
        this.policy.enqueue(queues,entity);
    }

    public Entity dequeue() {
        return this.policy.dequeue(this.queues);
    }

    @Override
    public String toString() {
        String ret = "id: " + this.id + " -- current entity: " + this.currentEntity.getId() + "\n"
                + "queues:\n";

        for (Queue q : queues)
            ret += "\t" + q.toString() + "\n";

        return ret;
    }
}
