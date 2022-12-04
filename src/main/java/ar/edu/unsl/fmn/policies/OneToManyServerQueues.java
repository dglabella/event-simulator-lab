package ar.edu.unsl.fmn.policies;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Queue;

public class OneToManyServerQueues implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        return queues.get(0).isEmpty();
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        queues.get(0).enqueue(entity);

    }

    @Override
    public Entity dequeue(List<Queue> queues) {
        return queues.get(0).next();
    }
}
