package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.Randomizer;
import ar.edu.unsl.fmn.utils.Utils;
import ar.edu.unsl.fmn.utils.distributions.*;

public class EndOfServiceBehavior implements Behavior {

    private Randomizer randomizer;
    private InvertibleDistribution<Double> distribution;
    private InvertibleDistribution<Double> distributionLight;
    private InvertibleDistribution<Double> distributionHeavy;

    public EndOfServiceBehavior(Randomizer randomizer) {
        this.randomizer = randomizer;
        this.distribution = new EmpiricalDiscrete<Double>();
        ((EmpiricalDiscrete) this.distribution).setPair(8d, 0.1);
        ((EmpiricalDiscrete) this.distribution).setPair(10d, 0.38);
        ((EmpiricalDiscrete) this.distribution).setPair(15d, 0.32);
        ((EmpiricalDiscrete) this.distribution).setPair(20d, 0.2);
        ((EmpiricalDiscrete) this.distribution).checkAndDone();

        this.distributionLight = new EmpiricalDiscrete<Double>();
        ((EmpiricalDiscrete) this.distributionLight).setPair(5d, 0.363);
        ((EmpiricalDiscrete) this.distributionLight).setPair(10d, 0.475);
        ((EmpiricalDiscrete) this.distributionLight).setPair(15d, 0.162);
        ((EmpiricalDiscrete) this.distributionLight).checkAndDone();

        this.distributionHeavy = new EmpiricalDiscrete<Double>();
        ((EmpiricalDiscrete) this.distributionHeavy).setPair(40d, 0.65);
        ((EmpiricalDiscrete) this.distributionHeavy).setPair(50d, 0.35);
        ((EmpiricalDiscrete) this.distributionHeavy).checkAndDone();
    }

    @Override
    public double nextTime(Entity entity, double clock) {
        Uniform unif;
        if (LightAircraft.class.equals(entity.getClass())) {
            return distributionLight.event(this.randomizer.nextRandom());
        } else if (MediumAircraft.class.equals(entity.getClass())) {
            unif = new Uniform(10d,20d);
            return unif.event(this.randomizer.nextRandom());
        } else if (HeavyAircraft.class.equals(entity.getClass())) {
            return distributionHeavy.event(this.randomizer.nextRandom());
        } else if (Maintenance.class.equals(entity.getClass())){
            unif = new Uniform(12d,24d);
            return unif.event(this.randomizer.nextRandom()) * 60d;
        }
        else{
            return this.distribution.event(this.randomizer.nextRandom());
        }
    }
}
