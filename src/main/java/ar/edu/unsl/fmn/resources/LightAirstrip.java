package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class LightAirstrip extends Airstrip{
    public LightAirstrip() {
        super(1000);
    }

    public LightAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy,1000);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "LightAirstrip";
    }
}
