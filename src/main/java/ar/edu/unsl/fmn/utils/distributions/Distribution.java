package ar.edu.unsl.fmn.utils.distributions;

public interface Distribution<T> {

    /**
     * get the probability of an event.
     * 
     * @param event the event which has the probability associated.
     * @return the probability of for the event.
     */
    Double probability(T event);

    /**
     * get a sample from this distribution.
     * 
     * @param cumulativeProbability the number (maybe a random one) for calculate which event should
     *        be returned.
     * @return the event that would have occurred given the cumulative probability.
     */
    T event(double cumulativeProbability);
}
