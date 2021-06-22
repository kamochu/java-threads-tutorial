package tech.meliora.natujenge.part13waitnotify4;

import tech.meliora.natujenge.part13waitnotify3.Task1;

import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Objective: Demonstrate and notify all
 */
public class Simulator {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");


        LinkedList<String> list = new LinkedList<>();

        int consumerInterval = 5000; //1 message in 5 seconds
        int producerInterval = 200; //5 messages per second
        int bufferSize = 3;

        Thread producer = new Thread(new Producer(list, producerInterval, bufferSize), "producer-1");
        Thread consumer1 = new Thread(new Consumer(list,  consumerInterval), "consumer-1");
        Thread consumer2 = new Thread(new Consumer(list,  consumerInterval), "consumer-2");
        Thread consumer3 = new Thread(new Consumer(list,  consumerInterval), "consumer-3");

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();


    }

}
