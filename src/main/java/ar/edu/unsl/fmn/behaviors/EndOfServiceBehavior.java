package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.utils.Randomizer;
import ar.edu.unsl.fmn.utils.distributions.InvertibleDistribution;
import ar.edu.unsl.fmn.utils.distributions.EmpiricalDiscrete;

public class EndOfServiceBehavior implements Behavior {

    private Randomizer randomizer;
    private InvertibleDistribution<Double> distribution;

    public EndOfServiceBehavior(Randomizer randomizer) {
        this.randomizer = randomizer;
        this.distribution = new EmpiricalDiscrete<Double>();
        ((EmpiricalDiscrete) this.distribution).setPair(8d, 0.1);
        ((EmpiricalDiscrete) this.distribution).setPair(10d, 0.38);
        ((EmpiricalDiscrete) this.distribution).setPair(15d, 0.32);
        ((EmpiricalDiscrete) this.distribution).setPair(20d, 0.2);

        ((EmpiricalDiscrete) this.distribution).checkAndDone();
    }

    @Override
    public double nextTime() {
        // return 11;
        return this.distribution.event(this.randomizer.nextRandom());
    }
}
