package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import ar.edu.unsl.fmn.utils.Utils;
import jdk.tools.jmod.Main;

import java.util.ArrayList;
import java.util.List;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        if(entity instanceof Maintenance){
            return Utils.serverForMaintenance(servers);
        }
        else{
            return Utils.filterServer(servers,entity);
        }
    }
}
