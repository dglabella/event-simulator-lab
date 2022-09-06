package ar.edu.unsl.fmn.policies;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Queue;

public interface ServerQueuePolicy {

    /**
     * check if there is some entity waiting in some queue.
     * 
     * @param queues the queues to be checked.
     * @return true if there is some entity waiting on some of the queues.
     */
    boolean queuesEmpty(List<Queue> queues);

    /**
     * queues an entity using the underlying policy implementation.
     * 
     * @param servers the queues list.
     * @param entity the entity to be queued in some queue.
     */
    void enqueue(List<Queue> queues, Entity entity);

    /**
     * dequeue the next entity using the underliying policy implementations.
     * 
     * @param queues the list of queues.
     * @return the entity to be dequeued from some of those queues.
     */
    Entity dequeue(List<Queue> queues);
}
