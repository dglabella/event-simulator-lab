package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.utils.Randomizer;
import ar.edu.unsl.fmn.utils.distributions.EmpiricalDiscrete;
import ar.edu.unsl.fmn.utils.distributions.InvertibleDistribution;

public class ArrivalBehavior implements Behavior {

    private Randomizer randomizer;
    private InvertibleDistribution<Double> distribution;

    public ArrivalBehavior(Randomizer randomizer) {
        this.randomizer = randomizer;
        this.distribution = new EmpiricalDiscrete<Double>();
        ((EmpiricalDiscrete) this.distribution).setPair(10d, 0.3);
        ((EmpiricalDiscrete) this.distribution).setPair(15d, 0.4);
        ((EmpiricalDiscrete) this.distribution).setPair(20d, 0.3);

        ((EmpiricalDiscrete) this.distribution).checkAndDone();
    }

    @Override
    public double nextTime() {
        // return 10;
        return this.distribution.event(this.randomizer.nextRandom());
    }
}
