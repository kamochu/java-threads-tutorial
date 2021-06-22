package tech.meliora.natujenge.part10jmm;

import java.time.LocalTime;

/**
 * Objective: JMM Concepts
 * <p>
 * This code block is meant to help us explain Java concurrency issues and help us understand Java Memory Model.
 * <p>
 * In this demo, we will try to understand what happened using JMM concepts.
 *
 * <p>
 * Concepts:
 * 1. Race Condition - two threads want the same shared resource at the same time.
 * 2. Critical section - the section of the code that accesses the shared resource.
 * 3. Monitor - a sync mechanism that allows threads to have mutual exclusion (mutex) and
 *  cooperation/collaboration.
 *  Features:
 * 3.1 only one thread has mutual exclusion access to the critical code section
 * 3.2 threads running in a monitor could be blocked while they are waiting for a certain condition to be met.
 * 3.2 one thread can notify other threads when when conditions they are waiting for on a monitor are met.
 * Reference: https://www.baeldung.com/cs/monitor
 *
 * <p>
 * 4. Mutual exclusion in Java:
 * 4.1 Synchronized method or block
 * 4.2 Using an object lock (instrinsic locks)
 * 4.3 Reentrant locks
 * 4.4 Semaphores
 */
public class SharedObjectDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        int x = 0; // stack - main thread

        MyRunnable runnable = new MyRunnable(); //stored in the heap,
        // but a pointer stored in the stack [main thread]

        Thread thread1 = new Thread(runnable, "my-runnable-1");
        Thread thread2 = new Thread(runnable, "my-runnable-2");

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
                + "|runnable.count: " + runnable.getCount());

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
