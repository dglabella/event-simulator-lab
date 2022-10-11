package ar.edu.unsl.fmn.policies;

import java.util.List;

import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.resources.Server;

public class UniqueServerSelectionPolicy implements ServerSelectionPolicy {

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        return servers.get(0);
    }
}
