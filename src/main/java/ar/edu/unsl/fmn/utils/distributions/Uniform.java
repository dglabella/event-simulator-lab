package ar.edu.unsl.fmn.utils.distributions;

public class Uniform implements Distribution<Double> {

    private double a;
    private double b;

    public Uniform(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Double probability(Double event) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double event(double cumulativeProbability) {
        return (this.b - this.a) * cumulativeProbability + this.a;
    }
}
