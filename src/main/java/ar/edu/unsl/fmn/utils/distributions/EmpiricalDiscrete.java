package ar.edu.unsl.fmn.utils.distributions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.edu.unsl.fmn.utils.exceptions.BadDistributionException;
import ar.edu.unsl.fmn.utils.exceptions.UnsafeDistributionException;
import ar.edu.unsl.fmn.utils.exceptions.OutOfRangeException;

/**
 * This class is an implementation for an empirical discrete distribution.
 * 
 */
public class EmpiricalDiscrete<T> implements Distribution<T> {
    private double sum;
    private boolean locked = false;

    private List<T> domain;
    private List<Double> range;

    private Map<T, Double> pairs;

    public EmpiricalDiscrete() {
        this.domain = new ArrayList<>();
        this.range = new ArrayList<>();
        this.pairs = new HashMap<>();
    }

    /**
     * set a pair (event, probability) for this empirical discrete distribution.
     *
     * @param event the event part of the pair.
     * @param probability the probability for the event.
     * @throws UnsafeDistributionException if add more pairs (event, probability) after the method
     *         checkAndDone was called.
     * @see {@link #checkAndDone()}
     */
    public void setPair(T event, double probability) {
        if (!locked) {
            sum += probability;
            this.pairs.put(event, probability);
            this.domain.add(event);
            this.range.add(probability);
        } else {
            throw new UnsafeDistributionException(
                    "cannot set more events and probabilities for this distribution, otherwise the distribution integrity will be lost");
        }
    }

    /**
     * This method checks if the sum of all probabilities is equal to 1. If true then this
     * distribution is ready to be used, but not otherwise. Is supposed to be called after add all
     * pairs for this distribution were added.
     * 
     * @throws BadDistributionException if the sum of all probabilities is not equal to 1.
     */
    public void checkAndDone() {
        if (sum != 1d) {
            throw new BadDistributionException("the sum of all probabilities must be equal to 1");
        } else {
            this.locked = true;
        }
    }

    @Override
    public Double probability(T event) {
        Double ret = null;
        if (locked) {
            ret = this.pairs.get(event);
        } else {
            throw new UnsafeDistributionException(
                    "call checkAndDone() method first to lock this distribution and check for its integrity.");
        }
        return ret;
    }

    @Override
    public T event(double cumulativeProbability) {
        int i = 0;

        if (locked) {
            if (cumulativeProbability < 0 || 1 < cumulativeProbability)
                throw new OutOfRangeException(
                        "cumulative probability cannot be greater than 1 or less than 0");


            while (cumulativeProbability > 0) {
                cumulativeProbability -= this.range.get(i);
                i++;
            }
        } else {
            throw new UnsafeDistributionException(
                    "call checkAndDone() method first to lock this distribution and check for its integrity.");
        }

        return i != 0 ? this.domain.get(i - 1) : this.domain.get(i);
    }
}
