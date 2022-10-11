package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.sun.source.tree.InstanceOfTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        System.out.println("selectServer in MultipleServerSelectionPolicy needs verification of functioning");
        Server server;

        if(entity.getClass().equals(new Maintenance())){
            int minDurability,currentServerWithMinDurability;
            //Seleccionar server con PROPORCION mas desgastada, no puede ser el auxiliar
            //Atento con la proporcion
        }
        else{
            List<Server> filteredservers = new ArrayList<>();
            String checkAirstripType = null;
            for(int i=0;i<servers.size();i++){
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

                            break;
                    }
                }
            }
            if (filteredservers.size() == 0){
                //esto seria un ret
                servers.get(servers.size() - 1); //esta va a ser la pista de mantenimiento
            }
            else{
                int minQueue = filteredservers.get(0).getMinCurrentQueueSize();
                int currentServerWithMinQueue = 0;
                for (int i=1;i<filteredservers.size();i++){
                    if(filteredservers.get(i).getMinCurrentQueueSize() < minQueue){
                        minQueue = filteredservers.get(i).getMinCurrentQueueSize();
                        currentServerWithMinQueue = i;
                        //Retornar el filteredserver i
                    }
                }
            }
        }






        si la entity no es de mantenimiento, tengo que ver a que server pertenece;
        este server se elige el que tenga menos cola, pero los que tengan asignado mantenimiento no se selecciona;











        for(int i=0; i < servers.size();i++){
            //el primer equals mepa que deberia preguntar por otra cosa che
            if((servers.get(i).getClass().equals(entity.getClass())) && (!(servers.get(i).checkForActivity(new Maintenance())))){
                filteredservers.add(servers.get(i));
            }
        }


        if(filteredservers.size() == 0){
            for(int i=0;i<servers.size();i++){
                if(servers.get(i).getClass().equals(Maintenance.class)){
                    ACA EN SI DEBERIA VER SI HAY ALGUNO LIBRE Y SINO DEVOLVER EL MENOR TAMANO DE COLA
                    return servers.get(i);
                }
            }
        }
        else{
            maxQueue = filteredservers.get(0).getQueueSize(); //VER SI LABURA BIEN
            for(int i=0;i<filteredservers.size();i++){
                if(!(filteredservers.get(i).isBusy())){
                    return filteredservers.get(i);
                }
            }
            for(int i=1;i<filteredservers.size();i++){
                if(filteredservers.get(i).getQueueSize() < maxQueue);{
                    maxQueue = filteredservers.get(i).getQueueSize();
                    server = filteredservers.get(i);
                }
            }
            return server;
        }

        TMB TENGO QUE VER SI TENGO UN MANTENIMMIENTO, O EL SERVER IS NULL Y LLEVARLA A LA AUXILIAR, AUXILIAR SIEMPRE TENGO UNA, FORZAR ESO
        //aca deberia ver cual server devuelvo dependiendo el tipo que se necesita, me imagino
        //la lista que le paso ya deberia tener solo los servidores de un tipo?
        //si es asi, tiro un random de alguna forma y divido sobre la long de esa lista
        //y de ahi decido a que server va? aleatoriamente?
        //o cuento todos y veo cual es el que tiene el server con menos cola?
        //o que politica de seleccion es??????

        return null;
    }
}
