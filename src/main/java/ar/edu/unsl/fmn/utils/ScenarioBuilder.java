package ar.edu.unsl.fmn.utils;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unsl.fmn.policies.OneToOneServerQueue;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.CustomQueue;
import ar.edu.unsl.fmn.resources.Queue;
import ar.edu.unsl.fmn.resources.Server;

public class ScenarioBuilder {

    public static List<Server> OneServerOneQueue() {
        List<Queue> queues = new ArrayList<>();
        //CustomQueue cq = new CustomQueue();
        /*Necesito como instanciar esto, o algo, pq al ser interface o dentro de CustomQueue no estar "Ccreado"
                me tira que la queue es null todo el tiempo, entonces al acceder a la cola tira npe*/
        //System.out.println(cq.getId());
        queues.add(new CustomQueue());

        List<Server> servers = new ArrayList<>();
        servers.add(new Airstrip(0,queues,new OneToOneServerQueue()));
        return servers;
    }

    public static List<Server> OneServerMultipleQueues(int queuesQuantity) {
        System.out.println("OneServerMultipleQueues in ScenarioBuilder: not yet implemented");
        return null;
    }

    public static List<Server> MultipleServersOneQueuePerServer(int queuesQuantity) {
        System.out.println("MultipleServersOneQueuePerServer in ScenarioBuilder: not yet implemented");
        return null;
    }
}
