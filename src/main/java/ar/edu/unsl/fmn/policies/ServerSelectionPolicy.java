package ar.edu.unsl.fmn.policies;

import java.util.List;
import ar.edu.unsl.fmn.resources.Server;

@FunctionalInterface
public interface ServerSelectionPolicy {

    Server selectServer(List<Server> servers);
}
