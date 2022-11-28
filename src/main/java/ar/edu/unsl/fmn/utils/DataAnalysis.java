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

    private final int n;
    private final int totalServers;
    private final int[] samplesAircraftAttendedTotal;
    private double meanOfMeansAircraftAttendedTotal;
    /*Livianas*/
    private final int[] samplesTotalAttendedLight;
    private double meanOfMeansTotalAttendedLight;
    private final double[] samplesTotalQueueWaitTimeLight;
    private double meanOfMeansTotalQueueWaitTimeLight;
    private final double[] samplesMedQueueWaitTimeLight;
    private double meanOfMeansMedQueueWaitTimeLight;
    private final double[] samplesMaxQueueWaitTimeLight;
    private double meanOfMeansMaxQueueWaitTimeLight;
    private final double[] samplesTotalServiceTimeLight;
    private double meanOfMeansTotalServiceTimeLight;
    private final double[] samplesMedServiceTimeLight;
    private double meanOfMeansMedServiceTimeLight;
    private final double[] samplesMaxServiceTimeLight;
    private double meanOfMeansMaxServiceTimeLight;


    /*Medianas*/
    private final int[] samplesTotalAttendedMedium;
    private double meanOfMeansTotalAttendedMedium;
    private final double[] samplesTotalQueueWaitTimeMedium;
    private double meanOfMeansTotalQueueWaitTimeMedium;
    private final double[] samplesMedQueueWaitTimeMedium;
    private double meanOfMeansMedQueueWaitTimeMedium;
    private final double[] samplesMaxQueueWaitTimeMedium;
    private double meanOfMeansMaxQueueWaitTimeMedium;
    private final double[] samplesTotalServiceTimeMedium;
    private double meanOfMeansTotalServiceTimeMedium;
    private final double[] samplesMedServiceTimeMedium;
    private double meanOfMeansMedServiceTimeMedium;
    private final double[] samplesMaxServiceTimeMedium;
    private double meanOfMeansMaxServiceTimeMedium;


    /*Pesadas*/
    private final int[] samplesTotalAttendedHeavy;
    private double meanOfMeansTotalAttendedHeavy;
    private final double[] samplesTotalQueueWaitTimeHeavy;
    private double meanOfMeansTotalQueueWaitTimeHeavy;
    private final double[] samplesMedQueueWaitTimeHeavy;
    private double meanOfMeansMedQueueWaitTimeHeavy;
    private final double[] samplesMaxQueueWaitTimeHeavy;
    private double meanOfMeansMaxQueueWaitTimeHeavy;
    private final double[] samplesTotalServiceTimeHeavy;
    private double meanOfMeansTotalServiceTimeHeavy;
    private final double[] samplesMedServiceTimeHeavy;
    private double meanOfMeansMedServiceTimeHeavy;
    private final double[] samplesMaxServiceTimeHeavy;
    private double meanOfMeansMaxServiceTimeHeavy;


    /*Servers*/
    private final int[][] samplesAircraftAttendedPerServer;
    private final double[] meanOfMeansAircraftAttendedPerServer;
    private final double[][] samplesTotalQueueWaitTimePerServer;
    private final double[] meanOfMeansTotalQueueWaitTimePerServer;
    private final double[][] samplesMedQueueWaitTimePerServer;
    private final double[] meanOfMeansMedQueueWaitTimePerServer;
    private final double[][] samplesMaxQueueWaitTimePerServer;
    private final double[] meanOfMeansMaxQueueWaitTimePerServer;
    private final double[][] samplesTotalServiceTimePerServer;
    private final double[] meanOfMeansTotalServiceTimePerServer;
    private final double[][] samplesMedServiceTimePerServer;
    private final double[] meanOfMeansMedServiceTimePerServer;
    private final double[][] samplesMaxServiceTimePerServer;
    private final double[] meanOfMeansMaxServiceTimePerServer;
    private final double[][] samplesTotalIdleTimePerServer;
    private final double[] meanOfMeansTotalIdleTimePerServer;
    private final double[][] samplesPercentageTotalIdleTimePerServer;
    private final double[] meanOfMeansPercentageTotalIdleTimePerServer;
    private final double[][] samplesMaxIdleTimePerServer;
    private final double[] meanOfMeansMaxIdleTimePerServer;
    private final double[][] samplesPercentageMaxIdleTimePerServer;
    private final double[] meanOfMeansPercentageMaxIdleTimePerServer;
    private final double[][] samplesMaxQueueSizePerServer;
    private final double[] meanOfMeansMaxQueueSizePerServer;
    private final double[][] samplesFinalDurabilityPerServer;
    private final double[] meanOfMeansFinalDurabilityPerServer;








    public DataAnalysis(Statistics[] statistics){
        /*
         * Inicializacion Variables
         */
        n = statistics.length;
        totalServers = statistics[0].getTotalServers();
        samplesAircraftAttendedTotal = new int[n];
        meanOfMeansAircraftAttendedTotal = 0;
        /*Livianas*/
        samplesTotalAttendedLight = new int[n];
        meanOfMeansTotalAttendedLight = 0;
        samplesTotalQueueWaitTimeLight = new double[n];
        meanOfMeansTotalQueueWaitTimeLight = 0;
        samplesMedQueueWaitTimeLight = new double[n];
        meanOfMeansMedQueueWaitTimeLight = 0;
        samplesMaxQueueWaitTimeLight = new double[n];
        meanOfMeansMaxQueueWaitTimeLight = 0;
        samplesTotalServiceTimeLight = new double[n];
        meanOfMeansTotalServiceTimeLight = 0;
        samplesMedServiceTimeLight = new double[n];
        meanOfMeansMedServiceTimeLight = 0;
        samplesMaxServiceTimeLight = new double[n];
        meanOfMeansMaxServiceTimeLight = 0;


        /*Medianas*/
        samplesTotalAttendedMedium = new int[n];
        meanOfMeansTotalAttendedMedium = 0;
        samplesTotalQueueWaitTimeMedium = new double[n];
        meanOfMeansTotalQueueWaitTimeMedium = 0;
        samplesMedQueueWaitTimeMedium = new double[n];
        meanOfMeansMedQueueWaitTimeMedium = 0;
        samplesMaxQueueWaitTimeMedium = new double[n];
        meanOfMeansMaxQueueWaitTimeMedium = 0;
        samplesTotalServiceTimeMedium = new double[n];
        meanOfMeansTotalServiceTimeMedium = 0;
        samplesMedServiceTimeMedium = new double[n];
        meanOfMeansMedServiceTimeMedium = 0;
        samplesMaxServiceTimeMedium = new double[n];
        meanOfMeansMaxServiceTimeMedium = 0;

        /*Pesadas*/
        samplesTotalAttendedHeavy = new int[n];
        meanOfMeansTotalAttendedHeavy = 0;
        samplesTotalQueueWaitTimeHeavy = new double[n];
        meanOfMeansTotalQueueWaitTimeHeavy = 0;
        samplesMedQueueWaitTimeHeavy = new double[n];
        meanOfMeansMedQueueWaitTimeHeavy = 0;
        samplesMaxQueueWaitTimeHeavy = new double[n];
        meanOfMeansMaxQueueWaitTimeHeavy = 0;
        samplesTotalServiceTimeHeavy = new double[n];
        meanOfMeansTotalServiceTimeHeavy = 0;
        samplesMedServiceTimeHeavy = new double[n];
        meanOfMeansMedServiceTimeHeavy = 0;
        samplesMaxServiceTimeHeavy = new double[n];
        meanOfMeansMaxServiceTimeHeavy = 0;

        /*Servers*/
        samplesAircraftAttendedPerServer = new int[n][totalServers];
        meanOfMeansAircraftAttendedPerServer = new double[totalServers];
        samplesTotalQueueWaitTimePerServer = new double[n][totalServers];
        meanOfMeansTotalQueueWaitTimePerServer = new double[totalServers];
        samplesMedQueueWaitTimePerServer = new double[n][totalServers];
        meanOfMeansMedQueueWaitTimePerServer = new double[totalServers];
        samplesMaxQueueWaitTimePerServer = new double[n][totalServers];
        meanOfMeansMaxQueueWaitTimePerServer = new double[totalServers];
        samplesTotalServiceTimePerServer = new double[n][totalServers];
        meanOfMeansTotalServiceTimePerServer = new double[totalServers];
        samplesMedServiceTimePerServer = new double[n][totalServers];
        meanOfMeansMedServiceTimePerServer = new double[totalServers];
        samplesMaxServiceTimePerServer = new double[n][totalServers];
        meanOfMeansMaxServiceTimePerServer = new double[totalServers];
        samplesTotalIdleTimePerServer = new double[n][totalServers];
        meanOfMeansTotalIdleTimePerServer = new double[totalServers];
        samplesPercentageTotalIdleTimePerServer = new double[n][totalServers];
        meanOfMeansPercentageTotalIdleTimePerServer = new double[totalServers];
        samplesMaxIdleTimePerServer = new double[n][totalServers];
        meanOfMeansMaxIdleTimePerServer = new double[totalServers];
        samplesPercentageMaxIdleTimePerServer = new double[n][totalServers];
        meanOfMeansPercentageMaxIdleTimePerServer = new double[totalServers];
        samplesMaxQueueSizePerServer = new double[n][totalServers];
        meanOfMeansMaxQueueSizePerServer = new double[totalServers];
        samplesFinalDurabilityPerServer = new double[n][totalServers];
        meanOfMeansFinalDurabilityPerServer = new double[totalServers];


        /*
         * Recupero Datos
         */
        for(int i=0; i< statistics.length; i++){
            samplesAircraftAttendedTotal[i] = statistics[i].getTotalAircraftAttended();
            /*Livianas*/
            samplesTotalAttendedLight[i] = statistics[i].getTotalHeavyAircraftAttended();
            samplesTotalQueueWaitTimeLight[i] = (statistics[i].getTotalQueueTimePerAircraft())[0];
            samplesMedQueueWaitTimeLight[i] = (statistics[i].getMedQueueTimePerAircraft())[0];
            samplesMaxQueueWaitTimeLight[i] = (statistics[i].getMaxQueueTimePerAircraft())[0];
            samplesTotalServiceTimeLight[i] = (statistics[i].getTotalServiceTimePerAircraft())[0];
            samplesMedServiceTimeLight[i] = (statistics[i].getMedServiceTimePerAircraft())[0];
            samplesMaxServiceTimeLight[i] = (statistics[i].getMaxServiceTimePerAircraft())[0];


            /*Medianas*/
            samplesTotalAttendedMedium[i] = statistics[i].getTotalMediumAircraftAttended();
            samplesTotalQueueWaitTimeMedium[i] = (statistics[i].getTotalQueueTimePerAircraft())[1];
            samplesMedQueueWaitTimeMedium[i] = (statistics[i].getMedQueueTimePerAircraft())[1];
            samplesMaxQueueWaitTimeMedium[i] = (statistics[i].getMaxQueueTimePerAircraft())[1];
            samplesTotalServiceTimeMedium[i] = (statistics[i].getTotalServiceTimePerAircraft())[1];
            samplesMedServiceTimeMedium[i] = (statistics[i].getMedServiceTimePerAircraft())[1];
            samplesMaxServiceTimeMedium[i] = (statistics[i].getMaxServiceTimePerAircraft())[1];


            /*Pesadas*/
            samplesTotalAttendedHeavy[i] = statistics[i].getTotalHeavyAircraftAttended();
            samplesTotalQueueWaitTimeHeavy[i] = (statistics[i].getTotalQueueTimePerAircraft())[2];
            samplesMedQueueWaitTimeHeavy[i] = (statistics[i].getMedQueueTimePerAircraft())[2];
            samplesMaxQueueWaitTimeHeavy[i] = (statistics[i].getMaxQueueTimePerAircraft())[2];
            samplesTotalServiceTimeHeavy[i] = (statistics[i].getTotalServiceTimePerAircraft())[2];
            samplesMedServiceTimeHeavy[i] = (statistics[i].getMedServiceTimePerAircraft())[2];
            samplesMaxServiceTimeHeavy[i] = (statistics[i].getMaxServiceTimePerAircraft())[2];


            /*Servers*/
            for(int j=0;j<totalServers;j++){
                samplesAircraftAttendedPerServer[i][j] = (statistics[i].getAircraftAttendedPerServer()[j]);
                samplesTotalQueueWaitTimePerServer[i][j] = (statistics[i].getTotalQueueWaitTimePerServer()[j]);
                samplesMedQueueWaitTimePerServer[i][j] = (statistics[i].getMedQueueWaitTimePerServer()[j]);
                samplesMaxQueueWaitTimePerServer[i][j] = (statistics[i].getMaxQueueWaitTimePerServer()[j]);
                samplesTotalServiceTimePerServer[i][j] = (statistics[i].getTotalServiceTimePerServer()[j]);
                samplesMedServiceTimePerServer[i][j] = (statistics[i].getMedServiceTimePerServer()[j]);
                samplesMaxServiceTimePerServer[i][j] = (statistics[i].getMaxServiceTimePerServer()[j]);
                samplesTotalIdleTimePerServer[i][j] = (statistics[i].getTotalIdleTimePerServer()[j]);
                samplesPercentageTotalIdleTimePerServer[i][j] = (statistics[i].getPercentageTotalIdleTime()[j]);
                samplesMaxIdleTimePerServer[i][j] = (statistics[i].getMaxIdleTimePerServer()[j]);
                samplesPercentageMaxIdleTimePerServer[i][j] = (statistics[i].getPercentageMaxIdleTime()[j]);
                samplesMaxQueueSizePerServer[i][j] = (statistics[i].getMaxQueueSizePerServer()[j]);
                samplesFinalDurabilityPerServer[i][j] = (statistics[i].getFinalDurabilityPerServer()[j]);
            }

        }
        /*
         * Medias de Medias
         */
        meanOfMeansAircraftAttendedTotal = estimateMedForInteger(samplesAircraftAttendedTotal);
        /*Livianas*/
        meanOfMeansTotalAttendedLight = estimateMedForInteger(samplesTotalAttendedLight);
        meanOfMeansTotalQueueWaitTimeLight = estimateMedForDoubles(samplesTotalQueueWaitTimeLight);
        meanOfMeansMedQueueWaitTimeLight = estimateMedForDoubles(samplesMedQueueWaitTimeLight);
        meanOfMeansMaxQueueWaitTimeLight = estimateMedForDoubles(samplesMaxQueueWaitTimeLight);
        meanOfMeansTotalServiceTimeLight = estimateMedForDoubles(samplesTotalServiceTimeLight);
        meanOfMeansMedServiceTimeLight = estimateMedForDoubles(samplesMedServiceTimeLight);
        meanOfMeansMaxServiceTimeLight = estimateMedForDoubles(samplesMaxServiceTimeLight);


        /*Medianas*/
        meanOfMeansTotalAttendedMedium = estimateMedForInteger(samplesTotalAttendedMedium);
        meanOfMeansTotalQueueWaitTimeMedium = estimateMedForDoubles(samplesTotalQueueWaitTimeMedium);
        meanOfMeansMedQueueWaitTimeMedium = estimateMedForDoubles(samplesMedQueueWaitTimeMedium);
        meanOfMeansMaxQueueWaitTimeMedium = estimateMedForDoubles(samplesMaxQueueWaitTimeMedium);
        meanOfMeansTotalServiceTimeMedium = estimateMedForDoubles(samplesTotalServiceTimeMedium);
        meanOfMeansMedServiceTimeMedium = estimateMedForDoubles(samplesMedServiceTimeMedium);
        meanOfMeansMaxServiceTimeMedium = estimateMedForDoubles(samplesMaxServiceTimeMedium);

        /*Pesadas*/
        meanOfMeansTotalAttendedHeavy = estimateMedForInteger(samplesTotalAttendedHeavy);
        meanOfMeansTotalQueueWaitTimeHeavy = estimateMedForDoubles(samplesTotalQueueWaitTimeHeavy);
        meanOfMeansMedQueueWaitTimeHeavy = estimateMedForDoubles(samplesMedQueueWaitTimeHeavy);
        meanOfMeansMaxQueueWaitTimeHeavy = estimateMedForDoubles(samplesMaxQueueWaitTimeHeavy);
        meanOfMeansTotalServiceTimeHeavy = estimateMedForDoubles(samplesTotalServiceTimeHeavy);
        meanOfMeansMedServiceTimeHeavy = estimateMedForDoubles(samplesMedServiceTimeHeavy);
        meanOfMeansMaxServiceTimeHeavy = estimateMedForDoubles(samplesMaxServiceTimeHeavy);


        /*Servers*/
        for(int j=0;j<totalServers;j++){
            meanOfMeansAircraftAttendedPerServer[j] = estimateMedForIntegerMatrix(samplesAircraftAttendedPerServer,n,j);
            meanOfMeansTotalQueueWaitTimePerServer[j] = estimateMedForDoubleMatrix(samplesTotalQueueWaitTimePerServer,n,j);
            meanOfMeansMedQueueWaitTimePerServer[j] = estimateMedForDoubleMatrix(samplesMedQueueWaitTimePerServer,n,j);
            meanOfMeansMaxQueueWaitTimePerServer[j] = estimateMedForDoubleMatrix(samplesMaxQueueWaitTimePerServer,n,j);
            meanOfMeansTotalServiceTimePerServer[j] = estimateMedForDoubleMatrix(samplesTotalServiceTimePerServer,n,j);
            meanOfMeansMedServiceTimePerServer[j] = estimateMedForDoubleMatrix(samplesMedServiceTimePerServer,n,j);
            meanOfMeansMaxServiceTimePerServer[j] = estimateMedForDoubleMatrix(samplesMaxServiceTimePerServer,n,j);
            meanOfMeansTotalIdleTimePerServer[j] = estimateMedForDoubleMatrix(samplesTotalIdleTimePerServer,n,j);
            meanOfMeansPercentageTotalIdleTimePerServer[j] = estimateMedForDoubleMatrix(samplesPercentageTotalIdleTimePerServer,n,j);
            meanOfMeansMaxIdleTimePerServer[j] = estimateMedForDoubleMatrix(samplesMaxIdleTimePerServer,n,j);
            meanOfMeansPercentageMaxIdleTimePerServer[j] = estimateMedForDoubleMatrix(samplesPercentageMaxIdleTimePerServer,n,j);
            meanOfMeansMaxQueueSizePerServer[j] = estimateMedForDoubleMatrix(samplesMaxQueueSizePerServer,n,j);
            meanOfMeansFinalDurabilityPerServer[j] = estimateMedForDoubleMatrix(samplesFinalDurabilityPerServer,n,j);
        }

    }

    private double estimateMedForInteger(int[] data){
        double res = 0;
        for (int datum : data) {
            res += datum;
        }
        if(res==0){
            return 0;
        }
        else{
            return res/data.length;
        }
    }

    private double estimateMedForDoubles(double[] data){
        double res = 0;
        for (double datum : data) {
            res += datum;
        }
        if(res==0){
            return 0;
        }
        else{
            return res/data.length;
        }
    }

    private double estimateMedForIntegerMatrix(int[][] data,int length,int server){
        double res = 0;
        for(int i=0;i<length;i++){
            res += data[i][server];
        }
        if(res==0){
            return 0;
        }
        else{
            return res/data.length;
        }
    }

    private double estimateMedForDoubleMatrix(double[][] data,int length,int server){
        double res = 0;
        for(int i=0;i<length;i++){
            res += data[i][server];
        }
        if(res==0){
            return 0;
        }
        else{
            return res/data.length;
        }
    }

    private double estimateStdDevSampleForIntegers(int[] data, double med){
        double res = 0;
        for (int datum : data) {
            res += Math.pow(datum - med, 2);
        }
        return(Math.sqrt(res / (data.length-1)));
    }

    private double estimateStdDevSampleForDoubles(double[] data, double med){
        double res = 0;
        for (double datum : data) {
            res += Math.pow(datum - med, 2);
        }
        return(Math.sqrt(res / (data.length-1)));
    }

    private double estimateStdDevSampleForIntegerMatrix(int[][] data,double med,int length,int server){
        double res = 0;
        for(int i=0;i<length;i++){
            res += Math.pow(data[i][server] - med,2);
        }
        return(Math.sqrt(res / (data.length-1)));
    }

    private double estimateStdDevSampleForDoubleMatrix(double[][] data,double med,int length,int server){
        double res = 0;
        for(int i=0;i<length;i++){
            res += Math.pow(data[i][server] - med,2);
        }
        return(Math.sqrt(res / (data.length-1)));
    }


    private double intervalLeft(double meanOfMeans, double stdDevS, int n){
        return (meanOfMeans - z*(stdDevS/Math.sqrt(n)));
    }
    private double intervalRight(double meanOfMeans, double stdDevS, int n){
        return (meanOfMeans + z*(stdDevS/Math.sqrt(n)));
    }


    public void printAnalytics (){
        System.out.println("Total de Entidades atendidas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansAircraftAttendedTotal,estimateStdDevSampleForIntegers(samplesAircraftAttendedTotal,meanOfMeansAircraftAttendedTotal),n) + "," +
                intervalRight(meanOfMeansAircraftAttendedTotal,estimateStdDevSampleForIntegers(samplesAircraftAttendedTotal,meanOfMeansAircraftAttendedTotal),n) + ")");
        /*Livianas*/
        System.out.println();
        System.out.println();
        System.out.println("Total de Entidades Livianas atendidas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalAttendedLight,estimateStdDevSampleForIntegers(samplesTotalAttendedLight,meanOfMeansTotalAttendedLight),n) + "," +
                intervalRight(meanOfMeansTotalAttendedLight,estimateStdDevSampleForIntegers(samplesTotalAttendedLight,meanOfMeansTotalAttendedLight),n) + ")");
        System.out.println("Tiempo Total de espera en cola de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeLight,meanOfMeansTotalQueueWaitTimeLight),n) + "," +
                intervalRight(meanOfMeansTotalQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeLight,meanOfMeansTotalQueueWaitTimeLight),n) + ")");
        System.out.println("Tiempo Medio de espera en cola de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeLight,meanOfMeansMedQueueWaitTimeLight),n) + "," +
                intervalRight(meanOfMeansMedQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeLight,meanOfMeansMedQueueWaitTimeLight),n) + ")");
        System.out.println("Tiempo Maximo de espera en cola de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeLight,meanOfMeansMaxQueueWaitTimeLight),n) + "," +
                intervalRight(meanOfMeansMaxQueueWaitTimeLight,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeLight,meanOfMeansMaxQueueWaitTimeLight),n) + ")");
        System.out.println("Tiempo Total de transito de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalServiceTimeLight,estimateStdDevSampleForDoubles(samplesTotalServiceTimeLight,meanOfMeansTotalServiceTimeLight),n) + "," +
                intervalRight(meanOfMeansTotalServiceTimeLight,estimateStdDevSampleForDoubles(samplesTotalServiceTimeLight,meanOfMeansTotalServiceTimeLight),n) + ")");
        System.out.println("Tiempo Medio de transito de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedServiceTimeLight,estimateStdDevSampleForDoubles(samplesMedServiceTimeLight,meanOfMeansMedServiceTimeLight),n) + "," +
                intervalRight(meanOfMeansMedServiceTimeLight,estimateStdDevSampleForDoubles(samplesMedServiceTimeLight,meanOfMeansMedServiceTimeLight),n) + ")");
        System.out.println("Tiempo Maximo de transito de Entidades Livianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxServiceTimeLight,estimateStdDevSampleForDoubles(samplesMaxServiceTimeLight,meanOfMeansMaxServiceTimeLight),n) + "," +
                intervalRight(meanOfMeansMaxServiceTimeLight,estimateStdDevSampleForDoubles(samplesMaxServiceTimeLight,meanOfMeansMaxServiceTimeLight),n) + ")");


        /*Medianas*/
        System.out.println();
        System.out.println();
        System.out.println("Total de Entidades Medianas atendidas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalAttendedMedium,estimateStdDevSampleForIntegers(samplesTotalAttendedMedium,meanOfMeansTotalAttendedMedium),n) + "," +
                intervalRight(meanOfMeansTotalAttendedMedium,estimateStdDevSampleForIntegers(samplesTotalAttendedMedium,meanOfMeansTotalAttendedMedium),n) + ")");
        System.out.println("Tiempo Total de espera en cola de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeMedium,meanOfMeansTotalQueueWaitTimeMedium),n) + "," +
                intervalRight(meanOfMeansTotalQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeMedium,meanOfMeansTotalQueueWaitTimeMedium),n) + ")");
        System.out.println("Tiempo Medio de espera en cola de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeMedium,meanOfMeansMedQueueWaitTimeMedium),n) + "," +
                intervalRight(meanOfMeansMedQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeMedium,meanOfMeansMedQueueWaitTimeMedium),n) + ")");
        System.out.println("Tiempo Maximo de espera en cola de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeMedium,meanOfMeansMaxQueueWaitTimeMedium),n) + "," +
                intervalRight(meanOfMeansMaxQueueWaitTimeMedium,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeMedium,meanOfMeansMaxQueueWaitTimeMedium),n) + ")");
        System.out.println("Tiempo Total de transito de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalServiceTimeMedium,estimateStdDevSampleForDoubles(samplesTotalServiceTimeMedium,meanOfMeansTotalServiceTimeMedium),n) + "," +
                intervalRight(meanOfMeansTotalServiceTimeMedium,estimateStdDevSampleForDoubles(samplesTotalServiceTimeMedium,meanOfMeansTotalServiceTimeMedium),n) + ")");
        System.out.println("Tiempo Medio de transito de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedServiceTimeMedium,estimateStdDevSampleForDoubles(samplesMedServiceTimeMedium,meanOfMeansMedServiceTimeMedium),n) + "," +
                intervalRight(meanOfMeansMedServiceTimeMedium,estimateStdDevSampleForDoubles(samplesMedServiceTimeMedium,meanOfMeansMedServiceTimeMedium),n) + ")");
        System.out.println("Tiempo Maximo de transito de Entidades Medianas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxServiceTimeMedium,estimateStdDevSampleForDoubles(samplesMaxServiceTimeMedium,meanOfMeansMaxServiceTimeMedium),n) + "," +
                intervalRight(meanOfMeansMaxServiceTimeMedium,estimateStdDevSampleForDoubles(samplesMaxServiceTimeMedium,meanOfMeansMaxServiceTimeMedium),n) + ")");


        /*Pesadas*/
        System.out.println();
        System.out.println();
        System.out.println("Total de Entidades Pesadas atendidas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalAttendedHeavy,estimateStdDevSampleForIntegers(samplesTotalAttendedHeavy,meanOfMeansTotalAttendedHeavy),n) + "," +
                intervalRight(meanOfMeansTotalAttendedHeavy,estimateStdDevSampleForIntegers(samplesTotalAttendedHeavy,meanOfMeansTotalAttendedHeavy),n) + ")");
        System.out.println("Tiempo Total de espera en cola de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeHeavy,meanOfMeansTotalQueueWaitTimeHeavy),n) + "," +
                intervalRight(meanOfMeansTotalQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesTotalQueueWaitTimeHeavy,meanOfMeansTotalQueueWaitTimeHeavy),n) + ")");
        System.out.println("Tiempo Medio de espera en cola de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeHeavy,meanOfMeansMedQueueWaitTimeHeavy),n) + "," +
                intervalRight(meanOfMeansMedQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeHeavy,meanOfMeansMedQueueWaitTimeHeavy),n) + ")");
        System.out.println("Tiempo Maximo de espera en cola de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeHeavy,meanOfMeansMaxQueueWaitTimeHeavy),n) + "," +
                intervalRight(meanOfMeansMaxQueueWaitTimeHeavy,estimateStdDevSampleForDoubles(samplesMaxQueueWaitTimeHeavy,meanOfMeansMaxQueueWaitTimeHeavy),n) + ")");
        System.out.println("Tiempo Total de transito de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansTotalServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesTotalServiceTimeHeavy,meanOfMeansTotalServiceTimeHeavy),n) + "," +
                intervalRight(meanOfMeansTotalServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesTotalServiceTimeHeavy,meanOfMeansTotalServiceTimeHeavy),n) + ")");
        System.out.println("Tiempo Medio de transito de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMedServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesMedServiceTimeHeavy,meanOfMeansMedServiceTimeHeavy),n) + "," +
                intervalRight(meanOfMeansMedServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesMedServiceTimeHeavy,meanOfMeansMedServiceTimeHeavy),n) + ")");
        System.out.println("Tiempo Maximo de transito de Entidades Pesadas:");
        System.out.println("(" +
                intervalLeft(meanOfMeansMaxServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesMaxServiceTimeHeavy,meanOfMeansMaxServiceTimeHeavy),n) + "," +
                intervalRight(meanOfMeansMaxServiceTimeHeavy,estimateStdDevSampleForDoubles(samplesMaxServiceTimeHeavy,meanOfMeansMaxServiceTimeHeavy),n) + ")");

        System.out.println("\n\n\n");
        for(int j=0;j<totalServers;j++){
            System.out.println("\n");
            System.out.println("Estadisticas servidor: " + j);

            System.out.println("Entidades atendidas en el servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansAircraftAttendedPerServer[j],estimateStdDevSampleForIntegerMatrix(samplesAircraftAttendedPerServer,meanOfMeansAircraftAttendedPerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansAircraftAttendedPerServer[j],estimateStdDevSampleForIntegerMatrix(samplesAircraftAttendedPerServer,meanOfMeansAircraftAttendedPerServer[j],n,j),n) + ")");
            System.out.println("Tiempo Total de espera en cola del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansTotalQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalQueueWaitTimePerServer,meanOfMeansTotalQueueWaitTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansTotalQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalQueueWaitTimePerServer,meanOfMeansTotalQueueWaitTimePerServer[j],n,j),n) + ")");
            System.out.println("Tiempo Medio de espera en cola del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMedQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMedQueueWaitTimePerServer,meanOfMeansMedQueueWaitTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMedQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMedQueueWaitTimePerServer,meanOfMeansMedQueueWaitTimePerServer[j],n,j),n) + ")");
            System.out.println("Tiempo Maximo de espera en cola del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMaxQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxQueueWaitTimePerServer,meanOfMeansMaxQueueWaitTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMaxQueueWaitTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxQueueWaitTimePerServer,meanOfMeansMaxQueueWaitTimePerServer[j],n,j),n) + ")");

            System.out.println("Tiempo Total de transito del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansTotalServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalServiceTimePerServer,meanOfMeansTotalServiceTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansTotalServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalServiceTimePerServer,meanOfMeansTotalServiceTimePerServer[j],n,j),n) + ")");
            System.out.println("Tiempo Medio de transito del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMedServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMedServiceTimePerServer,meanOfMeansMedServiceTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMedServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMedServiceTimePerServer,meanOfMeansMedServiceTimePerServer[j],n,j),n) + ")");
            System.out.println("Tiempo Maximo de transito del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMaxServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxServiceTimePerServer,meanOfMeansMaxServiceTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMaxServiceTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxServiceTimePerServer,meanOfMeansMaxServiceTimePerServer[j],n,j),n) + ")");

            System.out.println("Tiempo Total de ocio del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansTotalIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalIdleTimePerServer,meanOfMeansTotalIdleTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansTotalIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesTotalIdleTimePerServer,meanOfMeansTotalIdleTimePerServer[j],n,j),n) + ")");
            System.out.println("Porcentaje respecto del tiempo de simulacion:");
            System.out.println("(" +
                    String.format("%.2f",intervalLeft(meanOfMeansPercentageTotalIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesPercentageTotalIdleTimePerServer,meanOfMeansPercentageTotalIdleTimePerServer[j],n,j),n)) + "%"  + "," +
                    String.format("%.2f",intervalRight(meanOfMeansPercentageTotalIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesPercentageTotalIdleTimePerServer,meanOfMeansPercentageTotalIdleTimePerServer[j],n,j),n)) + "%" + ")");
            System.out.println("Tiempo Maximo de ocio del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMaxIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxIdleTimePerServer,meanOfMeansMaxIdleTimePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMaxIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxIdleTimePerServer,meanOfMeansMaxIdleTimePerServer[j],n,j),n) + ")");
            System.out.println("Porcentaje respecto del tiempo de simulacion:");
            System.out.println("(" +
                    String.format("%.2f",intervalLeft(meanOfMeansPercentageMaxIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesPercentageMaxIdleTimePerServer,meanOfMeansPercentageMaxIdleTimePerServer[j],n,j),n)) + "%" + "," +
                    String.format("%.2f",intervalRight(meanOfMeansPercentageMaxIdleTimePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesPercentageMaxIdleTimePerServer,meanOfMeansPercentageMaxIdleTimePerServer[j],n,j),n)) + "%" + ")");
            System.out.println("Tamaño Maximo de la cola de espera del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansMaxQueueSizePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxQueueSizePerServer,meanOfMeansMaxQueueSizePerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansMaxQueueSizePerServer[j],estimateStdDevSampleForDoubleMatrix(samplesMaxQueueSizePerServer,meanOfMeansMaxQueueSizePerServer[j],n,j),n) + ")");
            System.out.println("Durabilidad del suelo restante del servidor:");
            System.out.println("(" +
                    intervalLeft(meanOfMeansFinalDurabilityPerServer[j],estimateStdDevSampleForDoubleMatrix(samplesFinalDurabilityPerServer,meanOfMeansFinalDurabilityPerServer[j],n,j),n) + "," +
                    intervalRight(meanOfMeansFinalDurabilityPerServer[j],estimateStdDevSampleForDoubleMatrix(samplesFinalDurabilityPerServer,meanOfMeansFinalDurabilityPerServer[j],n,j),n) + ")");

        }



        /*
        Todo el desarrollo aca abajo fue para encontrar que faltaba un parentesis cuando dividia por n-1, el -1 lo tomaba fuera de la cuenta parece
        System.out.println("media de medias");
        System.out.println(meanOfMeansMedQueueWaitTimeHeavy);
        System.out.println("stdDev");
        System.out.println(estimateStdDevSampleForDoubles(samplesMedQueueWaitTimeHeavy,meanOfMeansMedQueueWaitTimeHeavy));
        for(int i=0;i<samplesMedQueueWaitTimeHeavy.length;i++){
            System.out.println(samplesMedQueueWaitTimeHeavy[i]);
        }

        System.out.println("potencia:");
        double aux =0;
        for(int i=0;i<samplesMedQueueWaitTimeHeavy.length;i++){
            aux += Math.pow(samplesMedQueueWaitTimeHeavy[i] - meanOfMeansMedQueueWaitTimeHeavy,2);
        }
        System.out.println((Math.sqrt(aux) / (samplesMedQueueWaitTimeHeavy.length -1)));
        */
    }
}
