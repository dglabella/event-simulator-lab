package ar.edu.unsl.fmn.policies;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Queue;

public class OneToManyServerQueues implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public Entity dequeue(List<Queue> queues) {
        // TODO Auto-generated method stub
        return null;
    }
}
