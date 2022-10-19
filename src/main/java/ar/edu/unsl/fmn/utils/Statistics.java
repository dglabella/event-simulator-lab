package ar.edu.unsl.fmn.utils;

import ar.edu.unsl.fmn.resources.Airstrip;
import ar.edu.unsl.fmn.resources.Server;

import java.util.List;

public class Statistics {

    private int totalAircraftAttended;

    private int aircraftAttendedPerServer[];

    private double totalQueueWaitTimePerServer[];

    private double finalDurabilityPerServer[];

    public Statistics(List<Server> servers){
        aircraftAttendedPerServer = new int[servers.size()];
        totalQueueWaitTimePerServer = new double[servers.size()];
        finalDurabilityPerServer = new double[servers.size()];
    }



    public void collectStatistics(List<Server> servers){



        for(int i=0;i<servers.size()-1;i++){
            totalAircraftAttended += servers.get(i).getEntityAttended();
            aircraftAttendedPerServer[i] = servers.get(i).getEntityAttended();

            totalQueueWaitTimePerServer[i] = servers.get(i).getTotalQueueTime();


            finalDurabilityPerServer[i] = ((Airstrip)servers.get(i)).getDurability();
        }


    }


    public void showReport(){
        System.out.println("Total de Entidades atendidas: " + totalAircraftAttended);
        //for (int i=0;i<aircraftAttendedPerServer.length;i++){
        //    System.out.println("Entidades atendidas en el servidor " + i + ": " + aircraftAttendedPerServer[i]);
        //}
        //
    }
}
