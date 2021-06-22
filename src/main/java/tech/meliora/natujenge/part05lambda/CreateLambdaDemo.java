package tech.meliora.natujenge.part05lambda;

import java.time.LocalTime;

/**
 * Objective: Create a thread using Lamda expressions
 * <p>
 *     Java Lambda expressions can be used in creating threads.
 *     The idea is to create a runnable without being too verbose.
 * <p>
 */
public class CreateLambdaDemo {

    public static void main(String[] args) {
        //this line will be printed by the main thread...
        //output: 06:22:05.766|main|this is my first line in my main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //Create a Thread instance and using Java lamda expressions
        //this is just a quick way of implement runnable block in a very short time
        //output: 06:42:49.487|my-lamda-thread|inside lamda code block
        Thread myThread = new Thread( () -> {
            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|inside lamda code block");
        }, "my-lamda-thread");


        myThread.start(); // you still have to call start method

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");


    }
}
