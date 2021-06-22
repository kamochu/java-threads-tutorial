package tech.meliora.natujenge.part07join;

import java.time.LocalTime;

/**
 * Objective: Demostrate Thread.join()
 * <p>
 * We have already observed that once the main thread has started a child thread,
 * the main thread execution moves to the next line of code.
 * <p>
 * At times we may have a scenario where you need the main thread to wait for the other thread to finish
 * e.g. you need some logic to be executed once some other logic has been completed.
 *
 * We can use the Thread.join() for Thread Synchronization
 *
 * Thread.join() - all actions in a thread happen-before any other thread successfully
 * returns from a join() on that thread
 *
 * <p>
 *
 * <p>
 */
public class ThreadJoinDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //my thread that runs a loops with sleep method
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
                + "|some code block before join is invoked");

        //public final void join() throws InterruptedException
        try{
            myThread.join();
            //myThread.join(7000L); //you can join with a timeout, comment on //myThread.join();
        }catch(InterruptedException ex){
            ex.printStackTrace(System.out);
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
