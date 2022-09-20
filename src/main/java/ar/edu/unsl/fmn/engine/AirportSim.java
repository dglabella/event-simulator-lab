package ar.edu.unsl.fmn.engine;

import java.util.List;
import java.util.Scanner;

import ar.edu.unsl.fmn.behaviors.ArrivalBehavior;
import ar.edu.unsl.fmn.behaviors.EndOfServiceBehavior;
import ar.edu.unsl.fmn.entities.Aircraft;
import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.events.StopSimulation;
import ar.edu.unsl.fmn.policies.ServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.Randomizer;

public class AirportSim implements Engine {

    private boolean stop = false;

    private FutureEventList fel;
    private List<Server> servers;

    private ServerSelectionPolicy policy;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy, Randomizer randomizer) {
        fel = new FutureEventList();
        this.servers = servers;
        this.policy = policy; //Para el generate report
        fel.insert(new StopSimulation(endClock,this));
        Aircraft entity = new Aircraft(1);
        Arrival arrival = new Arrival(0,
                entity,
                new ArrivalBehavior(randomizer),
                new EndOfServiceBehavior(randomizer),
                policy);

        entity.getEvents().add(arrival);
        fel.insert(arrival);
        //policy.selectServer(servers).addAircraftAttended();

    }

    @Override
    public void execute() {
        System.out.println(fel.toString());
        while(!stop){
            fel.getImminent().planificate(fel,servers);

            System.out.println("\nexecute in AirportSim: showing fel in every planificate step: (borrar este msg?)\n");
            System.out.println(fel.toString());
        }
    }

    @Override
    public void stopExecute() {
        stop = true;
    }

    @Override
    public void generateReport() {
        //Esto deberia estar asociado a una clase que me guarde las estadisticas y llamar a eso desde aca
        /*
        * R-Cantidad total de aeronaves que aterrizaron.
        * Ver bien el TIEMPO DE ESPERA, donde ponerlo, seria resta entre tiempo que entro la entidad a tiempo de
        * inicio de atencion quizas, para asegurarme que no sumo tiempos que no debo x entidades que no fueron atendidas todavia
        * N-Tiempo total de espera en cola. //PASAR A ENTIDADES ESTO?
        * N-Tiempo medio de espera en cola. //Sobre los que esperan solamente???? o sobre cant de entidades?
        * N-Tiempo máximo de espera en cola.
        * Podria ponerle a cada entidad el tiempo de espera que tiene c/u antes de ser atendida
        * R-Tiempo total de transito. TRANSITO ES TIEMPO DE SALIDA - TIEMPO DE ARRIBO
        * el transito es el tiempo desde que entra a la cola (o ser atendida si no hay) mas el tiempo que tarda en atenderse
        * R-Tiempo medio de tránsito.
        * R-Tiempo máximo de tránsito.
        * Tiempo total de ocio de la pista y el porcentaje que representa respecto del tiempo de simulación.
        * Tiempo máximo de ocio de la pista y el porcentaje que representa respecto del tiempo total de ocio.
        * R-Tamaño máximo de la cola de espera para este servidor.
         */
        System.out.println("Entidades atendidas: " + this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Total de espera en cola: " + this.policy.selectServer(servers).getTotalQueueTime());
        System.out.println("Tiempo Medio de espera en cola: " + this.policy.selectServer(servers).getTotalQueueTime()/this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Maximo de espera en cola: " + this.policy.selectServer(servers).getMaxQueueTime());
        System.out.println("Tiempo Total de transito: " + this.policy.selectServer(servers).getTotalServiceTime());
        System.out.println("Tiempo Medio de transito: " + this.policy.selectServer(servers).getTotalServiceTime()/this.policy.selectServer(servers).getAircraftAttended());
        System.out.println("Tiempo Maximo de transito: " + this.policy.selectServer(servers).getMaxServiceTime());
        /*
        El tiempo de ocio deberia estar implementado como un flag?
        Osea, en EoS se activa si no tengo cola y cuento hasta el proximo arrival, que si el flag esta levantado
        me lo deberia bajar y dejar de contar (sumar el tiempo acumulado del actual tiempo que tengo - tiempo
        en el que se levanta el flag) tiempo ahi.
        Puede ser tranquilamente un flag de la clase abstracta y el contador otro atributo, uno de maximo
        como vengo laburando y otro de total.
        cuando entra un arribo, si no habia cola (server desocupado) bajo el flag y sumo el tiempo
        cuando sale una entidad por un EoS levanto el flag y anoto en que tick de tiempo se produce esto
         */
        System.out.println("Tiempo Total de ocio de la pista: ");
        System.out.println("Porcentaje respecto del tiempo de simulacion: ");
        System.out.println("Tiempo maximo de ocio de la pista: ");
        System.out.println("Porcentaje respecto del tiempo de simulacion: ");
        System.out.println("Tamaño Maximo de la cola de espera para este servidor: " + this.policy.selectServer(servers).getMaxQueue());
        //por cada enqueue veo la lenght y veo si actualizo el max.
        System.out.println("generateReport in AirportSim: Implementation not finished");
    }
}
