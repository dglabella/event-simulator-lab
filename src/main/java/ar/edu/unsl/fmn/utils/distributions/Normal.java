package ar.edu.unsl.fmn.utils.distributions;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.Randomizer;

public class Normal implements Distribution<Double>, NonInvertibleDistribution<Double> {

    private final int n = 24;
    private final double uniformStdDev = Math.sqrt(n / 12d);

    private double mu;
    private double variance;
    private double stdDev;

    private Randomizer randomizer;

    public Normal(double mu, double variance) {
        this.mu = mu;
        this.variance = variance;
        this.stdDev = Math.sqrt(this.variance);
        this.randomizer = new CustomRandomizer();
    }

    public Normal(double mu, double variance, Randomizer randomizer) {
        this.mu = mu;
        this.variance = variance;
        this.stdDev = Math.sqrt(this.variance);
        this.randomizer = randomizer;
    }

    @Override
    public Double probability(Double event) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double event() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < this.n; i++)
            list.add(this.randomizer.nextRandom());

        double convolution = 0;
        double z = 0;

        for (double d : list) {
            convolution += d;
        }

        z = (convolution - 0.5d * this.n) / this.uniformStdDev;

        return z * this.stdDev + this.mu;
    }

    @Override
    public Double event(double mu, double variance, double... list) {
        double convolution = 0;
        double z = 0;
        for (double d : list) {
            convolution += d;
        }

        z = (convolution - mu * (list.length)) / Math.sqrt((variance * list.length));

        return z * Math.sqrt(this.variance) + this.mu;
    }
}
