package ar.edu.unsl.fmn.policies;

import java.util.List;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.entities.Entity;

@FunctionalInterface
public interface ServerSelectionPolicy {

    Server selectServer(List<Server> servers, Entity entity);
}
