package ar.edu.unsl.fmn.utils;

public class DataAnalysis {
    /**
     * Pasos:
     * 1) Calculo la media de medias: sumo todos los valores (50) y lo divido por n (50)
     * 2) Estandarizar
     * 3) Llamar al intervalo
     *
     */

    private final double z = 1.96;

    //Arrays datos

    private int n;
    private int totalAircraftAttended; //esta es media de medias,

    private int totalAircraftAttendedMuestra[];

    private int aircraftAttendedPerServer[];
    private int totalLightAircraftAttended[];
    private int totalMediumAircraftAttended[];
    private int totalHeavyAircraftAttended[];


    public DataAnalysis(Statistics[] statistics){
        n = statistics.length;
        totalAircraftAttended = 0;
        totalAircraftAttendedMuestra = new int[n];
        /*
        totalLightAircraftAttended = new int[statistics.length];
        totalMediumAircraftAttended = new int[statistics.length];
        totalHeavyAircraftAttended = new int[statistics.length];
*/

        //Recupero los datos
        for(int i=0; i< statistics.length; i++){
            totalAircraftAttendedMuestra[i] = statistics[i].getTotalAircraftAttended();
        }

        //Aca calculo la media de Medias, dejarlo aca o sacarlo?
        //Lo saco asi uso la funcion de abajo
        //O llamarla aca
        for(int i=0; i< statistics.length; i++){
            totalAircraftAttended += statistics[i].getTotalAircraftAttended();
        }
        totalAircraftAttended = totalAircraftAttended / statistics.length;
    }

    private double estimateMuForInteger(int[] data){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += data[i];
        }
        return res/data.length;
    }

    private double calculateMedForDoubles(double[] data){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += data[i];
        }
        return res/data.length;
    }

    private double estimateStdDevMuestralForInts(int[] data, double med){
        double res = 0;//era como suma de media de medias - media y elevado al cuadrado, y eso dividido n-1 la form
        for(int i=0;i<data.length;i++){
            res += Math.pow(data[i] - med,2);
        }
        return(Math.sqrt(res / data.length-1));
    }

    private double calculateStdDevForDoubs(double[] data, double med){
        double res = 0;
        for(int i=0;i<data.length;i++){
            res += Math.pow(data[i] - med,2);
        }
       // return(res / data.length-1);
    }


    private double intervalLeft(double medOfMeds, double stdDevMuestral, int n){
        return (medOfMeds - z*(stdDevMuestral/Math.sqrt(n)));
    }
    private double intervalRight(double medOfMeds, double stdDevMuestral, int n){
        return (medOfMeds + z*(stdDevMuestral/Math.sqrt(n)));
    }


    public void printAnalytics (){
        System.out.println("Total de Entidades atendidas:");
        System.out.println("(" + intervalLeft(totalAircraftAttended,estimateStdDevMuestralForInts(totalAircraftAttendedMuestra,totalAircraftAttended),n) + "," + intervalRight() + ")");
    }


}
