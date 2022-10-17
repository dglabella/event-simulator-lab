package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import jdk.tools.jmod.Main;

import java.util.ArrayList;
import java.util.List;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        Server server;

        if(entity instanceof Maintenance){
            Airstrip returnAirs =  null; //= (Airstrip)servers.get(0);
            Airstrip serverAux; //= (Airstrip)servers.get(0);
            double minDurability = Double.MAX_VALUE; //(serverAux.getDurability() / serverAux.getInitDurability());
            int currentServerWithMinDurability = 50;// = 0;
            //System.out.println(minDurability);
            for(int i=0;i<servers.size() - 1;i++){ //-1 por la auxiliar
                serverAux = (Airstrip) servers.get(i);
                System.out.println((serverAux.getDurability()/serverAux.getInitDurability()));
                if((serverAux.getDurability()/serverAux.getInitDurability()) <  minDurability){
                    minDurability = (serverAux.getDurability() / serverAux.getInitDurability());
                    returnAirs = serverAux;
                    currentServerWithMinDurability = i;

                }
            }
            for (int i=0;i<50;i++){
                System.out.println("Voy a dar el SERVER: " + currentServerWithMinDurability);
            }
            System.out.println(servers.get(currentServerWithMinDurability).toString());
            System.exit(0);
            return returnAirs;
            //return servers.get(currentServerWithMinDurability);
        }
        else{
            /**
             * Filtro los servidores por el tipo que sean
             */
            List<Server> filteredservers = new ArrayList<>();
            int instance = 0;
            if(entity instanceof LightAircraft){
                instance = 1;
            } else if (entity instanceof MediumAircraft) {
                instance = 2;
            } else if (entity instanceof HeavyAircraft) {
                instance = 3;
            }

            for(int i=0;i<servers.size() - 1;i++){//-1 por la pista auxiliar
                if(!(servers.get(i).checkForActivity(new Maintenance()))){
                    switch (instance){
                        case 1:
                            if(servers.get(i) instanceof LightAirstrip){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        case 2:
                            if(servers.get(i) instanceof MediumAirstrip){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        case 3:
                            if(servers.get(i) instanceof HeavyAirstrip){
                                filteredservers.add(servers.get(i));
                            }
                            break;
                        default:
                            System.out.println("No deberia entrar a este default, MultiplEserVErSelectionPolicy, puede ser pq no le digo que tipo de entity es a la fel");
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
            return server;
        }
    }
}
