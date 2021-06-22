package tech.meliora.natujenge.part02callrun;

import java.time.LocalTime;

/**
 * Objective 1: Create Thread and call run() instead of start()
 * <p>
 * part 01 we mentioned that for us to create thread, you need to create a thread instance and call Thread.start() method
 *
 * In this part 02, we will demonstrate the impact of calling Thread.run() instaed of Thread.start()
 *
 * How?
 *  1. We will modify MyThread class to have a while loop that runs forever
 *  2. We will create a MyThread instance and invoke Thread.run() instead of Thread.start()
 *
 * <p>
 *
 */
public class CreateThreadDemo {

    public static void main(String[] args) {

        //this line will be printed by the main thread...
        // we expect blow output:
        // 05:44:45.297|main|this is a line in the main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //creating MyThread instance
        MyThread myThread = new MyThread();
        //invoking Thread.run() instead of Thread.start()
        // output: The code block in run() will be executed by the main thread
        // this definitely gives you undesired result -
        // any line block below line 35 will wait for run() method to complete
        myThread.run();

        //line 39 will not be printed since the main thread is busy executing the logic in the  run() method
        // You can try changing line 35 to start and see the behavior change
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
