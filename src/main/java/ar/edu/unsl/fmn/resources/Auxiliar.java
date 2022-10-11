package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

import java.util.List;

public class Auxiliar extends Airstrip {
    public Auxiliar() {
        super(250);
    }

    public Auxiliar(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy, 250);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "Auxiliar";
    }
}
