package tech.meliora.natujenge.part06sleep;

import java.time.LocalTime;

/**
 * Objective: Demostrate Thread.sleep()
 * <p>
 * We need to invoke Thread.sleep() that takes in sleep time in millisecods  as a long
 * Thread.sleep() throws InterruptedException when the thread is interrupted..
 *
 * We will later revisted InterruptedException when dealing with stopping of Threads
 *
 * <p>
 */
public class ThreadSleepDemo {

    public static void main(String[] args) {
        //this line will be printed by the main thread...
        //output: 06:22:05.766|main|this is my first line in my main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //Create a Thread instance and using Java lamda expressions
        //this is just a quick way of implement runnable block in a very short time
        //output: 06:42:49.487|my-lamda-thread|inside lamda code block
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    //introduce sleep
                    //Thread.sleep(int milliseconds)
                    //public static native void sleep(long var0) throws InterruptedException;
                    //we will need to sorround our code block with try catch
                    try {
                        Thread.sleep(1000L); //sleep for 1000ms == 1 second
                    } catch (InterruptedException ex) {
                        ex.printStackTrace(System.out);
                    }

                    System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                            + "|inside loop, i = " + i);

                }
            }
        }, "my-thread");

        myThread.start(); // you still have to call start method
        //myThread.run(); // you can try this and uncomment this line and comment myThread.start();

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
