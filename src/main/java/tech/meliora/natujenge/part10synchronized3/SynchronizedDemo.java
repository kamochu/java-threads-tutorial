package tech.meliora.natujenge.part10synchronized3;

import java.time.LocalTime;

/**
 * Objective: Synchronization - Synchronized Block
 *
 * <p>
 * In this demo, we will demonstrate how one can synchronize threads using class.
 *
 * <p>
 * Refer: Synchronize on a static method
 */

public class SynchronizedDemo {

    private static int count = 0;

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    synchronized (SynchronizedDemo.class) {
                        count++; //increment count
                    }
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    synchronized (SynchronizedDemo.class) {
                        count++; //increment count
                    }
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
                + "|count: " + count);

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
