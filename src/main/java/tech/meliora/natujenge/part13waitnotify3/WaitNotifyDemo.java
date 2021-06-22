package tech.meliora.natujenge.part13waitnotify3;

import java.time.LocalTime;

/**
 * Objective: Demonstrate and notify all
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

            Thread.sleep(1000);

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|all threads blocked, waiting to be notified, wait for 4 seconds and "
                    + "we will wake all of them");

            Thread.sleep(4000);

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|**********************************************************");


        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

        //notifyAll wakes up on thread only
        synchronized (monitor) {
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|**********************************************************");
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|called monitor.notifyAll");
            monitor.notifyAll();

        }

        //wait for 2 seconds before looping
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }

}
