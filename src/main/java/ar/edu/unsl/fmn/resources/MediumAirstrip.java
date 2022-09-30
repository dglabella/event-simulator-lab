package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class MediumAirstrip extends Airstrip{
    public MediumAirstrip() {
        super();
        setDurability(3000);
    }

    public MediumAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy);
        setDurability(3000);
    }
}
