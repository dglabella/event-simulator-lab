package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class LightAirstrip extends Airstrip{
    public LightAirstrip() {
        super();
        setDurability(1000);
    }

    public LightAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy);
        setDurability(1000);
    }
}
