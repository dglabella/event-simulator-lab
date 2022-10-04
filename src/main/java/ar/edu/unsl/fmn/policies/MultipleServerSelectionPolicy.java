package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.Server;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.sun.source.tree.InstanceOfTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        List<Server> filteredservers = new ArrayList<>();
        Server server;
        int maxQueue;
        for(int i=0; i < servers.size();i++){
            if((servers.get(i).getClass().equals(entity.getClass())) && (!(servers.get(i).checkForActivity(new Maintenance())))){
                filteredservers.add(servers.get(i));
            }
        }

        System.out.println("selectServer in MultipleServerSelectionPolicy needs verification of functioning");
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

        cuando los aviones aterrizan gastan la pista

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
