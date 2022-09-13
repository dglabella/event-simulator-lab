package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.utils.Randomizer;
import ar.edu.unsl.fmn.utils.distributions.Distribution;

public class ArrivalBehavior implements Behavior {

    private Randomizer randomizer;
    private Distribution<Double> distribution;

    public ArrivalBehavior(Randomizer randomizer) {}

    @Override
    public double nextTime() {
        //Puse este return, pero no estaria usando la empirica discreta, no?
        return randomizer.nextRandom();
    }
}
