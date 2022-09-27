package ar.edu.unsl.fmn.utils.distributions;

public interface Distribution<T> {
    /**
     * get the probability of an event.
     * 
     * @param event the event which has the probability associated.
     * @return the probability of for the event.
     */
    Double probability(T event);
}
