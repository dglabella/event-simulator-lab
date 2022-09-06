package ar.edu.unsl.fmn.resources;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public abstract class Server {

    private int id;

    private Entity currentEntity;
    private List<Queue> queues;

    private ServerQueuePolicy policy;

    public Server() {}

    public Server(int id, List<Queue> queues, ServerQueuePolicy policy) {}

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

    public boolean isBusy() {
        return this.currentEntity == null ? false : true;
    }

    public boolean queuesEmpty() {}

    public void enqueue(Entity entity) {}

    public Entity dequeue() {}

    @Override
    public String toString() {
        String ret = "id: " + this.id + " -- current entity: " + this.currentEntity.getId() + "\n"
                + "queues:\n";

        for (Queue q : queues)
            ret += "\t" + q.toString() + "\n";

        return ret;
    }
}
