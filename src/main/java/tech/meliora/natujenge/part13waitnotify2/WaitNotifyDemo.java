package tech.meliora.natujenge.part13waitnotify2;

import tech.meliora.natujenge.part13waitnotify1.Task2;

import java.time.LocalTime;

/**
 * Objective: Demonstrate and notify all
 * <p>
 * Note: wait() must be within the sync block and has two effects - blocks  the thread and releases the monitor lock.
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        Object monitor = new Object();

        Thread thread1 = new Thread(new Task1(monitor), "task-1");
        Thread thread2 = new Thread(new Task1(monitor), "task-2");
        Thread thread3 = new Thread(new Task1(monitor), "task-3");
        Thread thread4 = new Thread(new Task1(monitor), "task-4");
        Thread thread5 = new Thread(new Task1(monitor), "task-5");


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        //wait for threads to finish before printing count
        try {
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|all threads blocked, waiting to be notified, wait for 5 seconds and "
                    + "we will start waking them up one by one");

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|**********************************************************");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }


        //notify wakes up one thread only

        //we will need to loop 5 times to wake up all threads
        for (int i = 0; i < 5; i++) {

            synchronized (monitor) {
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|**********************************************************");
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|called monitor.notify, i = " + i);
                monitor.notify();

            }

            //wait for 2 seconds before looping
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }

}
