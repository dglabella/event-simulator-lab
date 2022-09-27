package ar.edu.unsl.fmn.utils.distributions;

@FunctionalInterface
public interface InvertibleDistribution<T> {
    /**
     * get a sample from this distribution.
     * 
     * @param cumulativeProbability the number (maybe a random one) for calculate which event should
     *        be returned.
     * @return the event that would have occurred given the cumulative probability.
     */
    T event(double cumulativeProbability);
}
