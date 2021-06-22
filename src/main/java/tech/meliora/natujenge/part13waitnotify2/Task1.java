package tech.meliora.natujenge.part13waitnotify2;

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
                + "|begin");

        //this thread will wait to be notified
        try {
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|waiting to be notified");

            synchronized (monitor){
                monitor.wait();
            }

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|thread woken up");

        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|end ");

    }

}



