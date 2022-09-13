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
        queues.add(new CustomQueue());

        List<Server> servers = new ArrayList<>();
        servers.add(new Airstrip(0,queues,new OneToOneServerQueue()));
        return servers;
    }

    public static List<Server> OneServerMultipleQueues(int queuesQuantity) {
        return null;
    }

    public static List<Server> multipleServersOneQueuePerServer(int queuesQuantity) {
        return null;
    }
}
