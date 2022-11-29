package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.entities.Maintenance;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.Utils;

import java.util.List;

public class MultipleServerSelectionPolicyExperiment implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        if(entity instanceof Maintenance){
            return Utils.serverForMaintenance(servers);
        }
        else{
            return Utils.filterEquitativeServer(servers,entity);
        }
    }
}