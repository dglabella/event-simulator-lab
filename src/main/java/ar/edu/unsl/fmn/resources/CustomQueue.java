package ar.edu.unsl.fmn.resources;

import ar.edu.unsl.fmn.entities.Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;

    private int currentQueue;
    private int maxQueue;

    public CustomQueue(){
        id = 0;//?
        queue = new LinkedList<>(); //new PriorityQueue<>();?
        currentQueue = 0;
        maxQueue = 0;
    }
    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void enqueue(Entity entity) {
        this.queue.add(entity);
        this.currentQueue +=1;
        checkMaxQueue();
    }

    @Override
    public Entity checkNext() {
        return this.queue.peek();
    }

    @Override
    public Entity next() {
        this.currentQueue -=1;
        return this.queue.remove();

    }

    @Override
    public int getMaxQueue(){
        return this.maxQueue;
    }
    @Override
    public void checkMaxQueue() {
        if(maxQueue<currentQueue){
            maxQueue = currentQueue;
        }
    }
}
