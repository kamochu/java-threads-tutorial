package tech.meliora.natujenge.part10synchronized4;

import java.time.LocalTime;

/**
 * Objective: Synchronization - Synchronized Block
 *
 * <p>
 * In this demo, we will demonstrate how one can synchronized instance methods.
 *
 * <p>
 * We have a class Counter that has a method increment that is synchronized. This class is considered to be thread safe.
 *
 */

public class SynchronizedDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        Counter counter = new Counter();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    //Qtn? Do we need to sync this critical section
                    counter.increment();
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    counter.increment();
                }
            }
        }, "thread-2");

        thread1.start();
        thread2.start();

        //wait for threads to finish before printing count
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|count: " + counter.getCounter());

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
