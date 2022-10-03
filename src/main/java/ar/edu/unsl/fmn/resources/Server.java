package ar.edu.unsl.fmn.resources;

import java.util.List;
import ar.edu.unsl.fmn.entities.Entity;
import ar.edu.unsl.fmn.policies.ServerQueuePolicy;

public abstract class Server {

    private int id;

    private Entity currentEntity;

    private List<Queue> queues;

    private ServerQueuePolicy policy;

    private int aircraftAttended;
    private double totalQueueTime;
    private double maxQueueTime;

    private double totalServiceTime;

    private double maxServiceTime;

    private double idleStartTime;

    private double idleTotalTime;

    private double maxIdleTime;

    /*
    * Estos de queue time, deberian estar sobre la cola y no sobre el server, cierto?
    */

    public Server() {

    }

    public Server(int id, List<Queue> queues, ServerQueuePolicy policy) {
        this.id = id;
        this.queues = queues;
        this.policy = policy;
        this.aircraftAttended=0;
        this.totalQueueTime=0;
        this.maxQueueTime=0;
        this.totalServiceTime=0;
        this.maxServiceTime=0;
        this.maxIdleTime=0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity getCurrentEntity() {
        return this.currentEntity;
    }

    public void setCurrentEntity(Entity currentEntity) {
        this.currentEntity = currentEntity;
        ACA LLAMAR AL currentEntity.applyEffect(this);
        osea, aca tengo que desgastar
                this.durability o algo asi se lo cambio

                ;
        CREO QUE METO UN OVERRIDE A CADA HIJO DE ESTO
                Y AHI HAGO SUPER().setCurrentEntity(entity);
        Y AHI LE MODIFICO LA DURABILIDAD, SIGUIENTE A LO DE ARRIBA, EN EL PADRE EN EL OVERRIDE QUE DIJE
    }

    public int getAircraftAttended(){return this.aircraftAttended;}

    public void addAircraftAttended(){
        this.aircraftAttended += 1;
    }

    public double getTotalQueueTime(){
        return this.totalQueueTime;
    }

    public void setTotalQueueTime(double totalQueueTime){
        this.totalQueueTime = totalQueueTime;
    }

    public double getMaxQueueTime(){
        return this.maxQueueTime;
    }

    private void setMaxQueueTime(double maxQueueTime){
        this.maxQueueTime = maxQueueTime;
    }

    public double getTotalServiceTime(){
        return this.totalServiceTime;
    }

    private void setTotalServiceTime(double serviceTime){
        this.totalServiceTime = serviceTime;
    }

    public double getMaxServiceTime(){
        return this.maxServiceTime;
    }

    private void setMaxServiceTime(double maxServiceTime){
        this.maxServiceTime = maxServiceTime;
    }

    public double getIdleStartTime(){
        return this.idleStartTime;
    }

    public void setIdleStartTime(double idleStartTime){
        this.idleStartTime = idleStartTime;
    }

    public double getIdleTotalTime(){
        return this.idleTotalTime;
    }

    private void setIdleTotalTime(double idleTotalTime){
        this.idleTotalTime = idleTotalTime;
    }

    public double getMaxIdleTime(){
        return this.maxIdleTime;
    }

    private void setMaxIdleTime(double maxIdleTime){
        this.maxIdleTime = maxIdleTime;
    }

    public void addIdleTotalTime(double idleTime){
        setIdleTotalTime(getIdleTotalTime() + idleTime);
    }

    private void compareIdleMaxTime(double idleTime){
        if(getMaxIdleTime() < idleTime){
            setMaxIdleTime(idleTime);
        }
    }

    public void startIdle(double startTime){
        setIdleStartTime(startTime);
    }

    public void endIdle(double endTime){
        addIdleTotalTime( endTime - getIdleStartTime());
        compareIdleMaxTime(endTime - getIdleStartTime());
        setIdleStartTime(0);
    }

    public void addTotalQueueTime(double timeAdded){
        setTotalQueueTime(getTotalQueueTime() + timeAdded);
    }

    public void compareMaxQueueTime(double timeAdded){
        if(this.maxQueueTime < timeAdded){
            setMaxQueueTime(timeAdded);
        }
    }

    public void addTotalServiceTime(double timeAdded){
        setTotalServiceTime(getTotalServiceTime() + timeAdded);
    }

    public void compareMaxServiceTime(double serviceTime){
        if(this.maxServiceTime < serviceTime){
            setMaxServiceTime(serviceTime);
        }

    }

    public boolean isBusy() {
        return this.currentEntity == null ? false : true;
    }

    public boolean queuesEmpty() {
        return this.policy.queuesEmpty(this.queues);
        //return this.queues.isEmpty();
    }

    public void enqueue(Entity entity) {
        this.policy.enqueue(queues,entity);
        //aca puedo acceder para las colecciones de datos?
    }

    public Entity dequeue() {
        return this.policy.dequeue(this.queues);
        //aca puedo acceder para las colecciones de datos?
        //pq con el dequeue, puedo ver el tiempo de cola que tuvo digamos.
        //Por ahora lo implemente en el servidor, pero creo que esta mal
    }

    public int getMaxQueue(){
        return this.queues.get(0).getMaxQueue(); //este get(0) parece una negrada, revisar
    }

    @Override
    public String toString() {
        String ret = "id: " + this.id + " -- current entity: " + this.currentEntity.getId() + "\n"
                + "queues:\n";

        for (Queue q : queues)
            ret += "\t" + q.toString() + "\n";

        return ret;
    }
}
