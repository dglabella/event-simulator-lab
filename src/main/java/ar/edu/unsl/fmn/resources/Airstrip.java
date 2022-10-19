package ar.edu.unsl.fmn.resources;

import java.util.List;

import ar.edu.unsl.fmn.entities.Maintenance;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public class Airstrip extends Server {

    private double durability;

    private double initDurability;



    public Airstrip(double durability) {
        super();
        this.durability = durability;
        this.initDurability = durability;
    }

    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy, double durability) {
        super(id,queues,serverQueuePolicy);
        this.durability = durability;
        this.initDurability = durability;
    }

    public double getDurability(){
        return this.durability;
    }

    public void setDurability(double durability){
        this.durability = durability;
    }

    public double getInitDurability(){
        return this.initDurability;
    }

    public void updateDurability(double change){
        setDurability(this.durability + change);
    }



    /*public boolean isSettedMaintenance(){
        return this.checkForActivity(new Maintenance());
    }*/ //creo que esto ya lo hace el propio server buscando por entity con new Maintenance, ejemplo en selectServer de MultipleServerSelection


    @Override
    public void addEntityAttended(){
        if(!(this.getCurrentEntity() instanceof Maintenance)){
            setEntityAttended(getEntityAttended() + 1);
        }
    }





    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: airstrip";

        return ret;
    }
}
