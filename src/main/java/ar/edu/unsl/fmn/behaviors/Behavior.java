package ar.edu.unsl.fmn.behaviors;

import ar.edu.unsl.fmn.entities.Entity;

@FunctionalInterface
public interface Behavior {

    double nextTime(Entity entity, double clock);
}
