package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.utils.CustomRandomizer;
import ar.edu.unsl.fmn.utils.Randomizer;
import ar.edu.unsl.fmn.utils.Utils;
import ar.edu.unsl.fmn.utils.distributions.*;

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
    public double nextTime(Entity entity, double clock) {
        Exponential exp;
        Normal norm;
        CustomRandomizer rand = new CustomRandomizer();
        if (LightAircraft.class.equals(entity.getClass())) {
            if(Utils.esHoraPico(clock)){
                exp = new Exponential(20d);
            }
            else{
                exp = new Exponential(40d);
            }
            return exp.event(rand.nextRandom());
        } else if (MediumAircraft.class.equals(entity.getClass())) {
            if(Utils.esHoraPico(clock)){
                exp = new Exponential(15d);
            }
            else{
                exp = new Exponential(30d);
            }
            return exp.event(rand.nextRandom());
        } else if (HeavyAircraft.class.equals(entity.getClass())) {
            if(Utils.esHoraPico(clock)){
                norm = new Normal(30d,Math.pow(2d,2d));
            }
            else{
                norm = new Normal(60d,Math.pow(2d,2d));
            }
            return norm.event();
        } else if (Maintenance.class.equals(entity.getClass())){
            norm = new Normal(5,Math.pow(0.5,2));
            return norm.event() * 1440d;
        }
        else{
            return this.distribution.event(this.randomizer.nextRandom());
        }
    }

    @Override
    public Randomizer getRandomizer(){
        return this.randomizer;
    }
}
