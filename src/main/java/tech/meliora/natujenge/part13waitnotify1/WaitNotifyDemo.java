package tech.meliora.natujenge.part13waitnotify1;

import java.time.LocalTime;

/**
 * Objective: Demonstrate and notify all
 *
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        Object monitor = new Object();

        Thread thread1 = new Thread(new Task1(monitor), "task-1");
        Thread thread2 = new Thread(new Task2(monitor), "task-2");

        //you can try start thread2 before thread1
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
                + "|this is my last line in my main method");

    }

}
