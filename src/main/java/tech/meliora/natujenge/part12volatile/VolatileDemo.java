package tech.meliora.natujenge.part12volatile;

import java.time.LocalTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Objective: Understand Volatile keyword
 * <p>
 * Many may expect this program to simply print 42 after a short delay. However, in reality, the delay
 * may be much longer. It may even hang forever, or even print zero!
 * <p>
 * The cause of these anomalies is the lack of proper memory visibility and reordering.
 * <p>
 * Causes of the problem:
 * 1. Memory visibility - a value updated may not be flashed in memory
 * 2. Reordering - instructions are re-ordered by JVM, Compiler or Processor as part of optimization
 *
 */
public class VolatileDemo {

    public static void main(String[] args) {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");


        TaskRunner taskRunner = new TaskRunner();
        new Thread(taskRunner, "task-runner").start();
        taskRunner.number = 42;
        taskRunner.ready = true;

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }

}
