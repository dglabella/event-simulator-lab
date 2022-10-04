package ar.edu.unsl.fmn.resources;

import java.util.List;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public class Airstrip extends Server {

    private double durability;

    public Airstrip() {
        super();
    }

    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id,queues,serverQueuePolicy);
    }

    public double getDurability(){
        return this.durability;
    }

    public void setDurability(double durability){
        this.durability = durability;
    }

    public boolean isSettedMaintenance(){
        return this.g
    }



    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: airstrip";

        return ret;
    }
}
