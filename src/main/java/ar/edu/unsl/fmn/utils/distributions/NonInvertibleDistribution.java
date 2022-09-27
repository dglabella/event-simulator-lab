package ar.edu.unsl.fmn.utils.distributions;

public interface NonInvertibleDistribution<T> {

    /**
     * get a sample from this distribution.
     * 
     * @return the event sample.
     */
    T event();

    /**
     * get a sample from this distribution.
     * 
     * @param list the number list used to get the sample.
     * @return the event sample.
     */
    T event(double... list);
}
