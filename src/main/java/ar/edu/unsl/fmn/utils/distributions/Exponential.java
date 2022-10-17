package ar.edu.unsl.fmn.utils.distributions;
import java.lang.Math;

public class Exponential implements Distribution<Double>, InvertibleDistribution<Double> {

    private double lambda;
    public Exponential(double lambda){
        this.lambda = lambda;
    }


    @Override
    public Double probability(Double event) {
        return null;
    }

    @Override
    public Double event(double cumulativeProbability) {
        return (-1d / lambda) * Math.log(1d - cumulativeProbability);
    }
}
