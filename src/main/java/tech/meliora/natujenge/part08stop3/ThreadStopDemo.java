package tech.meliora.natujenge.part08stop3;

import java.time.LocalTime;

/**
 * Objective: Stop Thread
 * <p>
 * Do not use Thread.stop() method to stop a thread.
 * <p>
 * In this demo, we will interrupt the thread to stop it. When the thread it is interrupted,
 * it can carry out tasks that lead to graceful shutdown and then shutdown.
 *
 * <p>
 */
public class ThreadStopDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        MyForeverRunningRunnable runnable = new MyForeverRunningRunnable();
        Thread thread = new Thread(runnable, "my-forever-runnable");
        thread.start();

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|about to sleep for 5 seconds");

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

        thread.interrupt(); // interrupt the thread - for closure...

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");


    }
}
