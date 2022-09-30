package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.resources.Server;

import java.util.List;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{
    @Override
    public Server selectServer(List<Server> servers) {
        System.out.println("selectServer in MultipleServerSelectionPolicy needs reviews");
        //aca deberia ver cual server devuelvo dependiendo el tipo que se necesita, me imagino
        //la lista que le paso ya deberia tener solo los servidores de un tipo?
        //si es asi, tiro un random de alguna forma y divido sobre la long de esa lista
        //y de ahi decido a que server va? aleatoriamente?
        //o cuento todos y veo cual es el que tiene el server con menos cola?
        //o que politica de seleccion es??????
        return null;
    }
}
