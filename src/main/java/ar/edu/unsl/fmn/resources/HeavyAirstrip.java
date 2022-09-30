package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class HeavyAirstrip extends Airstrip{
    public HeavyAirstrip() {
        super();
        setDurability(5000);
    }

    public HeavyAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy);
        setDurability(5000);
    }
}
