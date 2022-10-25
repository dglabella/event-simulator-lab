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

    private double totalQueueTimePerAircraft[];
    private double medQueueTimePerAircraft[];
    private double maxQueueTimePerAircraft[];
    private double totalServiceTimePerAircraft[];
    private double medServiceTimePerAircraft[];
    private double maxServiceTimePerAircraft[];

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

    private int totalServers;

    private double stopTime;

    private double percentageTotalIdleTime;

    private double percentageMaxIdleTime;


    public Statistics(List<Server> servers, double stopTime){
        totalServers = servers.size();
        this.stopTime = stopTime;
        totalAircraftAttended = 0;
        aircraftAttendedPerServer = new int[totalServers];
        totalLightAircraftAttended = 0;
        totalMediumAircraftAttended = 0;
        totalHeavyAircraftAttended = 0;

        percentageTotalIdleTime = 0;
        percentageMaxIdleTime = 0;


        totalQueueWaitTimePerServer = new double[totalServers];
        maxQueueWaitTimePerServer = new double[totalServers];
        medQueueWaitTimePerServer = new double[totalServers];


        totalServiceTimePerServer = new double[totalServers];
        maxServiceTimePerServer = new double[totalServers];
        medServiceTimePerServer = new double[totalServers];


        totalIdleTimePerServer = new double[totalServers];
        maxIdleTimePerServer = new double[totalServers];
        maxQueueSizePerServer = new double[totalServers];
        finalDurabilityPerServer = new double[totalServers];

        totalQueueTimePerAircraft = new double[3];
        medQueueTimePerAircraft = new double[3];
        maxQueueTimePerAircraft = new double[3];
        totalServiceTimePerAircraft = new double[3];
        medServiceTimePerAircraft = new double[3];
        maxServiceTimePerAircraft = new double[3];


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
        }

        for(int i=0;i<3;i++){
            totalQueueTimePerAircraft[i] = 0;
            medQueueTimePerAircraft[i] = 0;
            maxQueueTimePerAircraft[i] = 0;
            totalServiceTimePerAircraft[i] = 0;
            medServiceTimePerAircraft[i] = 0;
            maxServiceTimePerAircraft[i] = 0;
        }
    }



    public void collectStatistics(List<Server> servers){
        int[] tipoAirstrip = new int[totalServers];
        for(int i=0;i<totalServers;i++){

            if(!(servers.get(i).isBusy())){
                servers.get(i).endIdle(stopTime);//Para terminar el idle de los servidores que entraron en idle
            }

            aircraftAttendedPerServer[i] = servers.get(i).getEntityAttended();

            tipoAirstrip[i] = Utils.verTipoServer(servers.get(i));
            switch (tipoAirstrip[i]){
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


            totalQueueWaitTimePerServer[i] = servers.get(i).getTotalQueueTime();
            maxQueueWaitTimePerServer[i] = servers.get(i).getMaxQueueTime();
            if(aircraftAttendedPerServer[i] ==0){
                medQueueWaitTimePerServer[i] = 0;
            }
            else{
                medQueueWaitTimePerServer[i] = (totalQueueWaitTimePerServer[i] / aircraftAttendedPerServer[i]);
            }


            totalServiceTimePerServer[i] = servers.get(i).getTotalServiceTime();
            maxServiceTimePerServer[i] = servers.get(i).getMaxServiceTime();
            if(aircraftAttendedPerServer[i] ==0){
                medServiceTimePerServer[i] = 0;
            }
            else{
                medServiceTimePerServer[i] = (servers.get(i).getTotalServiceTime() / aircraftAttendedPerServer[i]);
            }


            totalIdleTimePerServer[i] = servers.get(i).getIdleTotalTime();
            maxIdleTimePerServer[i] = servers.get(i).getMaxIdleTime();
            maxQueueSizePerServer[i] = servers.get(i).getMaxQueue();
            finalDurabilityPerServer[i] = ((Airstrip)servers.get(i)).getDurability();

            percentageTotalIdleTime = ((totalIdleTimePerServer[i] * 100) / stopTime);
            percentageMaxIdleTime = ((maxIdleTimePerServer[i] * 100) / stopTime);
        }


        for (int j=0;j<totalServers;j++){
            switch (tipoAirstrip[j]){
                case 1:
                    totalQueueTimePerAircraft[0] += totalQueueWaitTimePerServer[j];
                    totalServiceTimePerAircraft[0] += totalServiceTimePerServer[j];

                    if(maxQueueTimePerAircraft[0] < maxQueueWaitTimePerServer[j]){
                        maxQueueTimePerAircraft[0] = maxQueueWaitTimePerServer[j];
                    }
                    if(maxServiceTimePerAircraft[0] < maxServiceTimePerServer[j]){
                        maxServiceTimePerAircraft[0] = maxServiceTimePerServer[j];
                    }
                    break;
                case 2:
                    totalQueueTimePerAircraft[1] += totalQueueWaitTimePerServer[j];
                    totalServiceTimePerAircraft[1] += totalServiceTimePerServer[j];
                    if(maxQueueTimePerAircraft[1] < maxQueueWaitTimePerServer[j]){
                        maxQueueTimePerAircraft[1] = maxQueueWaitTimePerServer[j];
                    }
                    if(maxServiceTimePerAircraft[1] < maxServiceTimePerServer[j]){
                        maxServiceTimePerAircraft[1] = maxServiceTimePerServer[j];
                    }
                    break;
                case 3:
                    totalQueueTimePerAircraft[2] += totalQueueWaitTimePerServer[j];
                    totalServiceTimePerAircraft[2] += totalServiceTimePerServer[j];
                    if(maxQueueTimePerAircraft[2] < maxQueueWaitTimePerServer[j]){
                        maxQueueTimePerAircraft[2] = maxQueueWaitTimePerServer[j];
                    }
                    if(maxServiceTimePerAircraft[2] < maxServiceTimePerServer[j]){
                        maxServiceTimePerAircraft[2] = maxServiceTimePerServer[j];
                    }
                    break;
                default:
                    break;
            }
        }

        medQueueTimePerAircraft[0] = totalQueueTimePerAircraft[0] / totalLightAircraftAttended;
        medQueueTimePerAircraft[1] = totalQueueTimePerAircraft[1] / totalMediumAircraftAttended;
        medQueueTimePerAircraft[2] = totalQueueTimePerAircraft[2] / totalHeavyAircraftAttended;
        medServiceTimePerAircraft[0] = totalServiceTimePerAircraft[0] / totalLightAircraftAttended;
        medServiceTimePerAircraft[1] = totalServiceTimePerAircraft[1] / totalLightAircraftAttended;
        medServiceTimePerAircraft[2] = totalServiceTimePerAircraft[2] / totalLightAircraftAttended;


    }


    public void showReport(){
        System.out.println("Total de Entidades atendidas: " + totalAircraftAttended);
        System.out.println("Total de Entidades Livianas: " + totalLightAircraftAttended);
        System.out.println("Tiempo Total de espera en cola de Entidades Livianas: " + totalQueueTimePerAircraft[0]);
        System.out.println("Tiempo Medio de espera en cola de Entidades Livianas: " + medQueueTimePerAircraft[0]);
        System.out.println("Tiempo Maximo de espera en cola de Entidades Livianas: " + maxQueueTimePerAircraft[0]);
        System.out.println("Tiempo Total de transito en cola de Entidades Livianas: " + totalServiceTimePerAircraft[0]);
        System.out.println("Tiempo Medio de transito en cola de Entidades Livianas: " + medServiceTimePerAircraft[0]);
        System.out.println("Tiempo Maximo de transito en cola de Entidades Livianas: " + maxServiceTimePerAircraft[0]);
        System.out.println("\n");

        System.out.println("Total de Entidades Medianas: " + totalMediumAircraftAttended);
        System.out.println("Tiempo Total de espera en cola de Entidades Medianas: " + totalQueueTimePerAircraft[1]);
        System.out.println("Tiempo Medio de espera en cola de Entidades Medianas: " + medQueueTimePerAircraft[1]);
        System.out.println("Tiempo Maximo de espera en cola de Entidades Medianas: " + maxQueueTimePerAircraft[1]);
        System.out.println("Tiempo Total de transito en cola de Entidades Medianas: " + totalServiceTimePerAircraft[1]);
        System.out.println("Tiempo Medio de transito en cola de Entidades Medianas: " + medServiceTimePerAircraft[1]);
        System.out.println("Tiempo Maximo de transito en cola de Entidades Medianas: " + maxServiceTimePerAircraft[1]);
        System.out.println("\n");

        System.out.println("Total de Entidades Pesadas: " + totalHeavyAircraftAttended);
        System.out.println("Tiempo Total de espera en cola de Entidades Pesadas: " + totalQueueTimePerAircraft[2]);
        System.out.println("Tiempo Medio de espera en cola de Entidades Pesadas: " + medQueueTimePerAircraft[2]);
        System.out.println("Tiempo Maximo de espera en cola de Entidades Pesadas: " + maxQueueTimePerAircraft[2]);
        System.out.println("Tiempo Total de transito en cola de Entidades Pesadas: " + totalServiceTimePerAircraft[2]);
        System.out.println("Tiempo Medio de transito en cola de Entidades Pesadas: " + medServiceTimePerAircraft[2]);
        System.out.println("Tiempo Maximo de transito en cola de Entidades Pesadas: " + maxServiceTimePerAircraft[2]);

        System.out.println("\n\n\n");
        for (int i=0;i<totalServers;i++){

            System.out.println("Estadisticas servidor : " + i);

            System.out.println("Entidades atendidas en el servidor: " + aircraftAttendedPerServer[i]);

            System.out.println("Tiempo Total de espera en cola del servidor: " + totalQueueWaitTimePerServer[i]);
            System.out.println("Tiempo Medio de espera en cola del servidor: " + medQueueWaitTimePerServer[i]);
            System.out.println("Tiempo Maximo de espera en cola del servidor: " + maxQueueWaitTimePerServer[i]);

            System.out.println("Tiempo Total de transito del servidor: " + totalServiceTimePerServer[i]);
            System.out.println("Tiempo Medio de transito del servidor: " + medServiceTimePerServer[i]);
            System.out.println("Tiempo Maximo de transito del servidor: " + maxServiceTimePerServer[i]);

            System.out.println("Tiempo Total de ocio del servidor: " + totalIdleTimePerServer[i]);
            System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",percentageTotalIdleTime) + "%");
            System.out.println("Tiempo Maximo de ocio delservidor: " + maxIdleTimePerServer[i]);
            System.out.println("Porcentaje respecto del tiempo de simulacion: " + String.format("%.2f",percentageMaxIdleTime) + "%");
            System.out.println("Tamaño Maximo de la cola de espera del servidor: " + maxQueueSizePerServer[i]);
            System.out.println("Durabilidad del suelo restante del servidor: " + finalDurabilityPerServer[i]);

            System.out.println("\n\n\n");


        }
    }
}