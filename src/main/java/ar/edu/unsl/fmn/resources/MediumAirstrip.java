package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class MediumAirstrip extends Airstrip{
    public MediumAirstrip() {
        super(3000);
    }

    public MediumAirstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy,3000);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "MediumAirstrip";
    }

    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: medium";

        return ret;
    }
}
