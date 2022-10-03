package ar.edu.unsl.fmn.policies;

import ar.edu.unsl.fmn.resources.Server;

import java.util.List;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy{
    @Override
    public Server selectServer(List<Server> servers) {
        primer ohacer un filtro por is busy, el primero que este libre lo devielvpo
                si ninguno esta busy, ahi filtro por longitud de cola


        Server filteredServers = (falta inicializar;)servers.stream().filter(p p-> instanceof entity.agarrar tipo)

                for s in sublist
                if s.getqueue.getsize < MIN then serverret = s, min = s.getqueue.getsize;

        System.out.println("selectServer in MultipleServerSelectionPolicy needs reviews");
        Puedo poner flag en airstrip de mantenimiento y ACA PREGUNTAR SI EL FLAG ESTA LEVANTADO, ahi no la selecciono, limpiar el flag en la salida del mant

                SINO hacer un for para revisar toda la lista a ver si tiene un mantenimiento


                ;
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
