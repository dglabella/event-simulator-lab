package ar.edu.unsl.fmn;

import ar.edu.unsl.fmn.engine.AirportSim;
import ar.edu.unsl.fmn.engine.Engine;
import ar.edu.unsl.fmn.policies.MultipleServerSelectionPolicy;
import ar.edu.unsl.fmn.policies.OneToOneServerQueue;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;
import ar.edu.unsl.fmn.policies.UniqueServerSelectionPolicy;
import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.CustomQueue;
import ar.edu.unsl.fmn.resources.Queue;
import ar.edu.unsl.fmn.resources.Server;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.ScenarioBuilder;
import ar.edu.unsl.fmn.utils.distributions.Exponential;
import ar.edu.unsl.fmn.utils.distributions.Normal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private static final double SIMULATION_LENGHT = 40320d;
    // private static final double SIMULATION_LENGHT = 100d;

    public static void main(String[] args) {
        //Liviana: Exp 40
        //Mediana: Exp 30
        //Pesada: Normal (60,2)
        Exponential exponential1 = new Exponential(40);
        Exponential exponential2 = new Exponential(30);
        Random rand = new Random();



        Normal normal = new Normal(60,Math.pow(2,2));
        /*
        Normal normal = new Normal(120, 100);
        Random random = new Random(0);

        for (int i = 0; i < 50; i++) {
            System.out.println(normal.event());
        }
        System.out.println("=========================================================");

        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextGaussian() * 10 + 120);
        }

        */
        /*
        esto estaba en maintenance:
        @Override
    public boolean equals(Object obj) {
        return obj.getClass().getName() == "Maintenance"; //Ver que devuelva bien
    }
    se lo puse a los 3 aircrafts (light,medium,heavy)
    no se si ponerselo al server tmb
    porque comparo por esto.getclass
    yo creo que si, pq los usos de ese equals tmb los hago con los class de los airfields, mas que nada
    en clase Utils

    AGREGAR DSPUES pq ahora a cocinar


         */




        /*
        BORRAR LA DURABILIDAD DE LAS ENTITIES
        cosas a hacer:
        servidor auxiliar settearlo
        durabilidad
        maximo durabilidad registrado por pista
        ingreso de mantenimiento. CUANDO TENGO UN ARRIBO DE MANTENIMIENTO, setSettedMaintenance(true);

        analizar la FEL por los ingresos de distintos tipos

        un arribo de livianos es otro tipo respecto de arribo de medianos?

        Falta Hora Pico
        Detalle de aplicar el desgaste del aircraft 0 y de cada tipo setear el valor correspondiente, 0 pq asi no modifico, las otras van a ser negativos menos el manteminiemto que es positivo pq repara
        Ver el Dequeue
         */



        /**
         * Cuando se asigna un server a una entidad, a esa entidad se le asigna ese server
         * en alguna rama no anda esto, por el aply efect en EoS. se me rompia cuando hacia server.getEntity y tenia que hacer this.getEntity
         * de cola a server tengo que hacer el seteo de server a entidad y de entidad a server
         * Ver si el aply efect me rompe esa asoc de arriba
         */

        // para saber lo de hora pico hago modulo de cuantos minutos sean 24hs y si el arribo esta
        // entre
        // ese tiempo de hora pico le mando otra exponential

         Engine engine = new AirportSim( SIMULATION_LENGHT, ScenarioBuilder.MultipleServersOneQueuePerServer(),
         new MultipleServerSelectionPolicy(), new CustomRandomizer()); engine.execute();
         engine.generateReport();
    }

}
