package ar.edu.unsl.fmn.resources;

import java.util.List;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public class Airstrip extends Server {

    public Airstrip() {
        super();
    }

    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {}

    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: airstrip";

        return ret;
    }
}
