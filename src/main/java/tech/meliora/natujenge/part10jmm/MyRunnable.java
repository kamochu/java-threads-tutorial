package tech.meliora.natujenge.part10jmm;

import java.time.LocalTime;

/**
 *
 */
public class MyRunnable implements Runnable {

    //count is a member of class Runnable - stored in the heap[]
    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            count++; //increment count
        }
        long processingTime = System.currentTimeMillis() - start;
    }
}
