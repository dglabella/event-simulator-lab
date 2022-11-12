package ar.edu.unsl.fmn.utils;

public class DataAnalysis {

    private final double z = 1.96;

    //Arrays datos
    private int aircraftAttendedPerServer[];
    private int totalLightAircraftAttended[];
    private int totalMediumAircraftAttended[];
    private int totalHeavyAircraftAttended[];


    public DataAnalysis(Statistics[] statistics){
        aircraftAttendedPerServer = new int[statistics.length];
        totalLightAircraftAttended = new int[statistics.length];
        totalMediumAircraftAttended = new int[statistics.length];
        totalHeavyAircraftAttended = new int[statistics.length];
    }

    private double calculateMedForInts(int[] data){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += data[i];
        }
        return res/data.length;
    }

    private double calculateMedForDoubs(double[] data){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += data[i];
        }
        return res/data.length;
    }

    private double calculateStdDevForInts(int[] data, double med){
        double res = 0;//era como suma de media de medias - media y elevado al cuadrado, y eso dividido n-1 la form
        for(int i=0;i<data.length;i++){
            res += Math.pow(data[i] - med,2);
        }
        return(res / data.length-1);
    }

    private double calculateStdDevForDoubs(double[] data, double med){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += Math.pow(data[i] - med,2);
        }
        return(res / data.length-1);
    }


    private double intervalLeft(double medOfMeds, double mu, double stdDev, int n){
        return (((medOfMeds - mu) /(stdDev/Math.sqrt(n)))  - z);
    }
    private double intervalRight(double medOfMeds, double mu, double stdDev, int n){
        return (((medOfMeds - mu) /(stdDev/Math.sqrt(n)))  + z);
    }


}
