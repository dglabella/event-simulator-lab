package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.utils.Randomizer;


public interface Behavior {

    double nextTime(Entity entity, double clock);

    Randomizer getRandomizer();
}
