package tech.meliora.natujenge.part13waitnotify1;

import java.time.LocalTime;

/**
 * Source: https://www.baeldung.com/java-volatile
 */
public class Task2 implements Runnable {

    Object monitor;

    public Task2(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|task 2 started ");

        //this thread will wait to be notified
        try {
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|waiting to be notified");

            synchronized (monitor){
                monitor.wait(); //block....
            }

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|thread woken up by notify");

        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|task 2 end ");

    }

}



