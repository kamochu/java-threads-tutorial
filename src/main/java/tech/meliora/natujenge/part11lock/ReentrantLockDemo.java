package tech.meliora.natujenge.part11lock;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Objective: Synchronization - Synchronized Block
 * <p>
 * In this demo, we will demonstrate how one can synchronize threads using an Object lock or monitor.
 */
public class ReentrantLockDemo {

    private static int count = 0;


    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        Lock lock = new ReentrantLock();

        //Lock lock = new ReentrantLock(true); //fairness guarantee

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {

                    try {
                        lock.lock();
                        count++;

                    } finally {
                        lock.unlock();
                    }


                }
            }

        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    try {
                        lock.lock();
                        count++;
                    } finally {
                        lock.unlock();
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
