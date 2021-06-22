package tech.meliora.natujenge.part09daemon;

import java.time.LocalTime;

/**
 * This is a runnable that runs a background task that is only relevant when the parent thread is running.
 * <p>
 * Sample use cases where I think daemon threads can apply:
 * 1. A thread that maintains a session by sending heart bit requests , in case the session thread dies,
 * we do not need the daemon thread. In this case, the daemon thread does not have a state to the saved.
 * 2. A threads that sends delivery receipts to an active SMPP session, if the session dies,
 * the delivery receipts sending daemon should die too.
 * 3. Java Garbage collection. If the main thread dies, no need to carry out garbage collection activities
 * (the JVM will be shutdown)
 * <p>
 * You have to really analyse and see that a daemon thread works best for your use case.
 * <p>
 * I will be glad to hear use cases that may have worked for you.
 */
public class MyForeverDaemon implements Runnable {

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000); //sleep 1000ms = 1 second

                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|inside the MyForeverRunningRunnable.run() method");

            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }

        }

    }
}
