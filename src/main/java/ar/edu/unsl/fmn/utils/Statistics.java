package ar.edu.unsl.fmn.utils;

import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.Server;

import java.util.List;

public class Statistics {

    private int totalAircraftAttended;
    private int totalLightAircraftAttended;
    private int totalMediumAircraftAttended;
    private int totalHeavyAircraftAttended;

    private int aircraftAttendedPerServer[];

    private double totalQueueWaitTimePerServer[];

    private double maxQueueWaitTimePerServer[];

    private double medQueueWaitTimePerServer[];

    private double totalServiceTimePerServer[];
    private double maxServiceTimePerServer[];
    private double medServiceTimePerServer[];

    private double totalIdleTimePerServer[];
    private double maxIdleTimePerServer[];

    private double finalDurabilityPerServer[];

    private double maxQueueSizePerServer[];

    private double coladelserver[];

    private int totalServers;
    private double stopTime;

    public Statistics(List<Server> servers, double stopTime){
        totalServers = servers.size();
        this.stopTime = stopTime;

        aircraftAttendedPerServer = new int[totalServers];
        totalQueueWaitTimePerServer = new double[totalServers];
        maxQueueWaitTimePerServer = new double[totalServers];
        medQueueWaitTimePerServer = new double[totalServers];


        totalIdleTimePerServer = new double[totalServers];
        maxIdleTimePerServer = new double[totalServers];
        maxQueueSizePerServer = new double[totalServers];


        totalServiceTimePerServer = new double[totalServers];
        maxServiceTimePerServer = new double[totalServers];
        medServiceTimePerServer = new double[totalServers];


        finalDurabilityPerServer = new double[totalServers];
        coladelserver = new double[totalServers];


        totalAircraftAttended = 0;
        totalLightAircraftAttended = 0;
        totalMediumAircraftAttended = 0;
        totalHeavyAircraftAttended = 0;
        for (int i = 0; i<totalServers;i++){
            aircraftAttendedPerServer[i] = 0;
            totalQueueWaitTimePerServer[i] = 0;
            maxQueueWaitTimePerServer[i] = 0;
            medQueueWaitTimePerServer[i] = 0;
            totalServiceTimePerServer[i] = 0;
            maxServiceTimePerServer[i] = 0;
            medServiceTimePerServer[i] = 0;
            totalIdleTimePerServer[i] = 0;
            maxIdleTimePerServer[i] = 0;
            maxQueueSizePerServer[i] = 0;

            finalDurabilityPerServer[i] = 0;
            coladelserver[i] = 0;
        }
    }



    public void collectStatistics(List<Server> servers){
        int tipoAirstrip = 0;
        for(int i=0;i<totalServers;i++){

            if(!(servers.get(i).isBusy())){
                servers.get(i).endIdle(stopTime);//Para terminar el idle de los servidores que entraron en idle
            }

            aircraftAttendedPerServer[i] = servers.get(i).getEntityAttended();
            tipoAirstrip = Utils.verTipoServer(servers.get(i));
            switch (tipoAirstrip){
                case 1:
                    totalLightAircraftAttended += aircraftAttendedPerServer[i];
                    break;
                case 2:
                    totalMediumAircraftAttended += aircraftAttendedPerServer[i];
                    break;
                case 3:
                    totalHeavyAircraftAttended += aircraftAttendedPerServer[i];
                    break;
                default:
                    break;
            }

            totalAircraftAttended += aircraftAttendedPerServer[i];

            /*if(!(i == totalServers-1)){ //esta linea no contabiliza las entidades atendidas por la pista auxiliar
            //no le veo sentido a que exista, consultar si se deben contabilizar o no los atendidos por la auxiliar
                totalAircraftAttended += aircraftAttendedPerServer[i];
            }*/

            totalQueueWaitTimePerServer[i] = servers.get(i).getTotalQueueTime();
            maxQueueWaitTimePerServer[i] = servers.get(i).getMaxQueueTime();
            if(aircraftAttendedPerServer[i] ==0){
                medQueueWaitTimePerServer[i] = 0;
            }
            else{
                medQueueWaitTimePerServer[i] = (totalQueueWaitTimePerServer[i] / aircraftAttendedPerServer[i]);
            }
            //medQueueWaitTimePerServer[i] = (totalQueueWaitTimePerServer[i] / aircraftAttendedPerServer[i]);
            totalServiceTimePerServer[i] = servers.get(i).getTotalServiceTime();
            maxServiceTimePerServer[i] = servers.get(i).getMaxServiceTime();
            if(aircraftAttendedPerServer[i] ==0){
                medServiceTimePerServer[i] = 0;
            }
            else{
                medServiceTimePerServer[i] = (servers.get(i).getTotalServiceTime() / aircraftAttendedPerServer[i]);
            }
            //medServiceTimePerServer[i] = (servers.get(i).getTotalServiceTime() / aircraftAttendedPerServer[i]);

            totalIdleTimePerServer[i] = servers.get(i).getIdleTotalTime();
            maxIdleTimePerServer[i] = servers.get(i).getMaxIdleTime();
            maxQueueSizePerServer[i] = servers.get(i).getMaxQueue();
            finalDurabilityPerServer[i] = ((Airstrip)servers.get(i)).getDurability();

            coladelserver[i] = servers.get(i).getMinCurrentQueueSize();

            /**
             * ACOMODAR EL ORDEN PARA TENERLO ORDENADO
             */
        }




    }


    public void showReport(){
        System.out.println("Total de Entidades atendidas: " + totalAircraftAttended);
        System.out.println("Total de Entidades Livianas: " + totalLightAircraftAttended);
        System.out.println("Total de Entidades Medianas: " + totalMediumAircraftAttended);
        System.out.println("Total de Entidades Pesadas: " + totalHeavyAircraftAttended);
        System.out.println("\n\n\n");
        for (int i=0;i<totalServers;i++){

            System.out.println("Estadisticas servidor : " + i);

            System.out.println("Entidades atendidas en el servidor: " + aircraftAttendedPerServer[i]);

            System.out.println("Tiempo Total de espera en cola del servidor: " + totalQueueWaitTimePerServer[i]);
            System.out.println("Tiempo Medio de espera en cola del servidor: " + medQueueWaitTimePerServer[i]);
            System.out.println("Tiempo Maximo de espera en cola del servidor: " + maxQueueWaitTimePerServer[i]);
            System.out.println("Tiempo Total de transito total del servidor: " + totalServiceTimePerServer[i]);
            System.out.println("Tiempo Medio de transito medio del servidor: " + medServiceTimePerServer[i]);
            System.out.println("Tiempo Maximo de transito maximo del servidor: " + maxServiceTimePerServer[i]);
            System.out.println("Tiempo Total de ocio del servidor: " + totalIdleTimePerServer[i]);
            System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",((totalIdleTimePerServer[i] * 100) / stopTime)) + "%");
            System.out.println("Tiempo Maximo de ocio delservidor: " + maxIdleTimePerServer[i]);
            System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",((maxIdleTimePerServer[i] * 100) / stopTime)) + "%");
            System.out.println("Tamaño Maximo de la cola de espera del servidor: " + maxQueueSizePerServer[i]);
            System.out.println("Durabilidad del suelo restante del servidor: " + finalDurabilityPerServer[i]);


            System.out.println("Tamaño de cola actual del servidor: " + coladelserver[i]);

            System.out.println("\n\n\n");


        }
    }
}
