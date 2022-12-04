package ar.edu.unsl.fmn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unsl.fmn.policies.OneToManyServerQueues;
import ar.edu.unsl.fmn.policies.OneToOneServerQueue;
import ar.edu.unsl.fmn.resources.*;

public class ScenarioBuilder {

    public static List<Server> OneServerOneQueue() {
        List<Queue> queues = new ArrayList<>();
        queues.add(new CustomQueue());

        List<Server> servers = new ArrayList<>();
        servers.add(new Airstrip(0,queues,new OneToOneServerQueue(),0));
        return servers;
    }

    public static List<Server> OneServerMultipleQueues(int queuesQuantity) {
        System.out.println("OneServerMultipleQueues in ScenarioBuilder: not yet implemented");
        return null;
    }

    public static List<Server> MultipleServersOneQueuePerServer() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int pl,pm,pp,pa;
        System.out.println("Cuantas pistas Livianas?");
        pl=3;
        /*try {
            pl = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("Cuantos pistas Medianas?");
        pm=4;
        /*try {
            pm = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("Cuantos pistas Pesadas?");
        pp=2;
        /*try {
            pp = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        pa=1;


        List<Server> servers = new ArrayList<>();
        int j=0;
        for(int i=0;i<pl;i++){
            List<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue());
            servers.add(new LightAirstrip(j,queues,new OneToOneServerQueue()));
            j++;
        }
        for(int i=0;i<pm;i++){
            List<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue());
            servers.add(new MediumAirstrip(j,queues,new OneToOneServerQueue()));
            j++;
        }
        for(int i=0;i<pp;i++){
            List<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue());
            servers.add(new HeavyAirstrip(j,queues,new OneToOneServerQueue()));
            j++;
        }
        for(int i=0;i<pa;i++){
            List<Queue> queues = new ArrayList<>();
            queues.add(new CustomQueue());
            servers.add(new Auxiliar(j,queues,new OneToOneServerQueue()));
            j++;
        }
        return servers;
    }

    public static List<Server> MultipleServersOneQueue() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int pl,pm,pp,pa;
        //System.out.println("Cuantas pistas Livianas?");
        pl=1;
        /*try {
            pl = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //System.out.println("Cuantos pistas Medianas?");
        pm=2;
        /*try {
            pm = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //System.out.println("Cuantos pistas Pesadas?");
        pp=1;
        /*try {
            pp = Integer.parseInt( reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        pa=1;
        List<Queue> queuesl = new ArrayList<>();
        queuesl.add(new CustomQueue());
        List<Queue> queuesm = new ArrayList<>();
        queuesm.add(new CustomQueue());
        List<Queue> queuesh = new ArrayList<>();
        queuesh.add(new CustomQueue());
        List<Queue> queues = new ArrayList<>();
        queues.add(new CustomQueue());

        List<Server> servers = new ArrayList<>();
        int j=0;
        for(int i=0;i<pl;i++){
            servers.add(new LightAirstrip(j,queuesl,new OneToManyServerQueues()));
            j++;
        }
        for(int i=0;i<pm;i++){
            servers.add(new MediumAirstrip(j,queuesm,new OneToManyServerQueues()));
            j++;
        }
        for(int i=0;i<pp;i++){
            servers.add(new HeavyAirstrip(j,queuesh,new OneToManyServerQueues()));
            j++;
        }
        for(int i=0;i<pa;i++){
            servers.add(new Auxiliar(j,queues,new OneToManyServerQueues()));
            j++;
        }
        return servers;
    }
}
