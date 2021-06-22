package tech.meliora.natujenge.part10synchronized2;

import java.time.LocalTime;

/**
 * Objective: Synchronization - Synchronized Block
 *
 * In this demo, we will demonstrate how one can synchronize threads using this (instance of a class).
 *
 */
public class SynchronizedDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        MyRunnable runnable = new MyRunnable();
        MyRunnable runnable2 = new MyRunnable();

        //Qtn? what would happen if we had two runnable instances... would there be a race condition?

        Thread thread1 = new Thread(runnable,"runnable-1");
        Thread thread2 = new Thread(runnable,"runnable-2");

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
                + "|runnable.count: " + runnable.getCount());

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
