package tech.meliora.natujenge.part13waitnotify1;

import java.time.LocalTime;

/**
 * Source: https://www.baeldung.com/java-volatile
 */
public class Task1 implements Runnable {

    Object monitor;

    public Task1(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|task 1 begin");
        try {

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|simulating a heavy task that will take 3 seconds to complete");

            //simulating a task that takes a long time to complete - sleep for some seconds
            Thread.sleep(6000);

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|task 1 complete ");

            synchronized (monitor) {
                monitor.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|task 1 end ");

    }

}



