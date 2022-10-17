package ar.edu.unsl.fmn.utils.distributions;
import java.lang.Math;

public class Exponential implements Distribution<Double>, InvertibleDistribution<Double> {

    private double mu;
    public Exponential(double mu){
        this.mu = mu;
    }


    @Override
    public Double probability(Double event) {
        return null;
    }

    @Override
    public Double event(double cumulativeProbability) {
        return (-mu) * Math.log(1d - cumulativeProbability);
    }
}
