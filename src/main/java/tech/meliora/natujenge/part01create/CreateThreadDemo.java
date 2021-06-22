package tech.meliora.natujenge.part01create;

import java.time.LocalTime;

/**
 * Objective: Create Thread by extending Thread class and use Thread.currentThread() method
 * <p>
 * In this demo we will create MyThread class that extends Thread class
 * We will also introduce Thread.currentThread() method that can be
 * used to print the name of the thread that printed the code block
 *
 * We will also introduce naming a thread
 * <p>
 * We will also introduce LocalDateTime.now().toString() to help us print the current date and time
 */
public class CreateThreadDemo {
    public static void main(String[] args) {

        //this line will be printed by the main thread...
        // we expect blow output:
        // 06:19:16.751|main|this is a line in the main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is a line in the main method");

        //creating MyThread instance
        MyThread myThread = new MyThread();
        //Thread.sart() - starts a Java Thread and invokes the run method
        // expected output:
        // 06:19:16.754|Thread-0|this line is inside the MyThread.run() method
        //
        // NOTE: the thread has a name in format Thread-X by default assigned by the JVM execution engine
        myThread.start();




        //creating a named thread instance
        MyThread myThread2 = new MyThread("my-thread-name");
        //Thread.sart() - starts a Java Thread and invokes the run method
        // expected output:
        // 06:19:16.757|my-thread-name|this line is inside the MyThread.run() method
        //
        // NOTE: the thread has a custom name instad of Thread-X assigned by JVM execution engine
        myThread2.start();


        MyThread myThread3 = new MyThread();

        myThread3.start();

    }
}
