package ar.edu.unsl.fmn.utils;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import ar.edu.unsl.fmn.utils.distributions.Exponential;
import ar.edu.unsl.fmn.utils.distributions.Normal;
import ar.edu.unsl.fmn.utils.distributions.Uniform;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static double calculateDmg(Entity entity, Airstrip server){
        CustomRandomizer rand = new CustomRandomizer();
        double dmg = 0;
        Uniform dist;
        if (LightAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(0,1);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (MediumAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(1,4);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (HeavyAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(3,6);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (Maintenance.class.equals(entity.getClass())){
            dmg = server.getInitDurability() * 15 / 100;
        }
        return dmg;
    }

    public static boolean esHoraPico(double clock){
        double mod = clock % 1440;
        if(((mod >= 420) && (mod <= 600)) || ((mod >= 1140) && (mod <= 1320))){
            return true;
        }
        else{
            return false;
        }
    }

    public static Server serverForMaintenance(List<Server> servers){
        Airstrip server = null, serverAux = null;

        double minProportion = Double.MAX_VALUE, auxProportion;

        for (int i = 0; i < servers.size() - 1; i++){
            serverAux = (Airstrip) servers.get(i);
            auxProportion = (serverAux.getDurability() / serverAux.getInitDurability());
            if(minProportion > auxProportion){
                minProportion = auxProportion;
                server = serverAux;
            }
        }
        return server;
    }

    public static Server filterServer(List<Server> servers,Entity entity){
        Server server;
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
                        System.exit(0);
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
