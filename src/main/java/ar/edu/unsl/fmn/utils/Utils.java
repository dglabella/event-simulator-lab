package ar.edu.unsl.fmn.utils;

import ar.edu.unsl.fmn.entities.*;
import ar.edu.unsl.fmn.resources.*;
import ar.edu.unsl.fmn.utils.distributions.Exponential;
import ar.edu.unsl.fmn.utils.distributions.Normal;
import ar.edu.unsl.fmn.utils.distributions.Uniform;

public class Utils {
    public static double calculateDmg(Entity entity, Airstrip server){
        CustomRandomizer rand = new CustomRandomizer();
        double dmg = 0;
        Uniform dist;
        if (LightAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(0,1);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (MediumAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(1,4);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (HeavyAircraft.class.equals(entity.getClass())) {
            dist = new Uniform(3,6);
            dmg = 0 - dist.event(rand.nextRandom());
        } else if (Maintenance.class.equals(entity.getClass())){
            dmg = server.getInitDurability() * 15 / 100;
        }
        return dmg;
    }

    public static boolean esHoraPico(double clock){
        double mod = clock % 1440;
        if(((mod >= 420) && (mod <= 600)) || ((mod >= 1140) && (mod <= 1320))){
            return true;
        }
        else{
            return false;
        }
    }
}
