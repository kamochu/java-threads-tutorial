package tech.meliora.natujenge.part14state;

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

        int consumerInterval = 5000;
        int producerInterval = 200;
        int bufferSize = 3;

        Thread producer = new Thread(new Producer(list, producerInterval, bufferSize), "producer-1");
        Thread consumer1 = new Thread(new Consumer(list, consumerInterval), "consumer-1");
        Thread consumer2 = new Thread(new Consumer(list, consumerInterval), "consumer-2");
        Thread consumer3 = new Thread(new Consumer(list, consumerInterval), "consumer-3");

        //main - RUNNABLE, rest NEW
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|main-state: " + Thread.currentThread().getState() + "|before-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|producer-state: " + producer.getState() + "|before-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer1-state: " + consumer1.getState() + "|before-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|before-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|before-thread-start");


        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();


        //lock  - waiting for lock, time waiting, main - RUNNABLE
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|main-state: " + Thread.currentThread().getState() + "|after-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|producer-state: " + producer.getState() + "|after-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer1-state: " + consumer1.getState() + "|after-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-start");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-start");

        for (int i = 0; i < 3; i++) {

            //do it for 30 seconds...
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|main-state: " + Thread.currentThread().getState() + "|main-thread-loop");
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|producer-state: " + producer.getState() + "|main-thread-loop");
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|consumer1-state: " + consumer1.getState() + "|main-thread-loop");
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|consumer2-state: " + consumer2.getState() + "|main-thread-loop");
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|consumer2-state: " + consumer2.getState() + "|main-thread-loop");

        }


        producer.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|main-state: " + Thread.currentThread().getState() + "|after-thread-interrupt");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|producer-state: " + producer.getState() + "|after-thread-interrupt");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer1-state: " + consumer1.getState() + "|after-thread-interrupt");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-interrupt");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-interrupt");


        try {
            producer.join();
            consumer1.join();
            consumer2.join();
            consumer3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace(System.out);
        }

        //terminated
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|main-state: " + Thread.currentThread().getState() + "|after-thread-join");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|producer-state: " + producer.getState() + "|after-thread-join");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer1-state: " + consumer1.getState() + "|after-thread-join");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-join");
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|consumer2-state: " + consumer2.getState() + "|after-thread-join");

    }

}
