package tech.meliora.natujenge.part09daemon;

import java.time.LocalTime;

/**
 * Objective: Stop Thread
 * <p>
 * Do not use Thread.stop() method to stop a thread.
 * <p>
 * <p>
 * In this demo, we will interrupt the thread to stop it but we will also check interrupted flag on the
 * thread just in case a task does not throw InterruptedException. When the thread it is interrupted,
 * it can carry out tasks that lead to graceful shutdown and then shutdown.
 * <p>
 */
public class ThreadDaemonDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        MyForeverDaemon runnable = new MyForeverDaemon();
        Thread thread = new Thread(runnable, "my-forever-daemon");
        thread.setDaemon(true); //this has to be called before starting a thread
        thread.start();

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|about to sleep for 5 seconds");

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
