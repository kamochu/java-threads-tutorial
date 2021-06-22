package tech.meliora.natujenge.part12volatile;

import java.time.LocalTime;

/**
 *
 * Source: https://www.baeldung.com/java-volatile
 *
 */
public class TaskRunner implements Runnable {

    static int number;
    volatile static boolean ready;

    @Override
    public void run() {

        while (!ready) {
            Thread.yield();
        }

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|number: "+number);

    }

}



