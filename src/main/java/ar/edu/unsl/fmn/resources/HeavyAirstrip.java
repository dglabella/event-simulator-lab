package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class HeavyAirstrip extends Airstrip{
    public HeavyAirstrip() {
        super(5000);
    }

    public HeavyAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy,5000);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "HeavyAirstrip";
    }
}
