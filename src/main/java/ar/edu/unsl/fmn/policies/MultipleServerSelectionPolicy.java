package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import java.util.ArrayList;
import java.util.List;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        System.out.println("selectServer in MultipleServerSelectionPolicy needs verification of functioning");
        Server server = null;

        if(entity.getClass().equals(new Maintenance())){
            Airstrip serverAux;
            serverAux = (Airstrip)servers.get(0);
            double minDurability = serverAux.getDurability() / serverAux.getInitDurability();
            int currentServerWithMinDurability = 0;

            for(int i=1;i<servers.size() - 1;i++){ //-1 por la auxiliar
                serverAux = (Airstrip) servers.get(i);
                if(serverAux.getDurability()/serverAux.getInitDurability() <  minDurability){
                    minDurability = serverAux.getDurability() / serverAux.getInitDurability();
                    currentServerWithMinDurability = i;
                }
            }
            server = servers.get(currentServerWithMinDurability);
        }
        else{
            List<Server> filteredservers = new ArrayList<>();
            String checkAirstripType = null;
            for(int i=0;i<servers.size() - 1;i++){//-1 por la pista auxiliar
                if(!(servers.get(i).checkForActivity(new Maintenance()))){
                    if(entity.getClass().equals(new LightAircraft())){
                        checkAirstripType = "LightAirstrip";
                    }
                    else if(entity.getClass().equals(new MediumAircraft())){
                        checkAirstripType = "MediumAirstrip";
                    }
                    else if(entity.getClass().equals(new HeavyAircraft())){
                        checkAirstripType = "HeavyAirstrip";
                    }
                    switch(checkAirstripType){
                        case "LightAirstrip":
                            if(servers.get(i).getClass().equals(new LightAirstrip())){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        case "MediumAirstrip":
                            if(servers.get(i).getClass().equals(new MediumAirstrip())){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        case "HeavyAirstrip":
                            if(servers.get(i).getClass().equals(new HeavyAirstrip())){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        default:
                            System.out.println("Default branch not yet implemented in SelectServer on MultipleServerSelecionPolicy");
                            break;
                    }
                }
            }
            if (filteredservers.size() == 0){
                server = servers.get(servers.size() - 1); //esta va a ser la pista de mantenimiento
            }
            else{
                int minQueue = filteredservers.get(0).getMinCurrentQueueSize();
                int currentServerWithMinQueue = 0;
                for (int i=1;i<filteredservers.size();i++){
                    if(filteredservers.get(i).getMinCurrentQueueSize() < minQueue){
                        minQueue = filteredservers.get(i).getMinCurrentQueueSize();
                        currentServerWithMinQueue = i;
                    }
                }
                server = filteredservers.get(currentServerWithMinQueue);
            }
        }
        return server;
    }
}
