package tech.meliora.natujenge.part10synchronized2;

/**
 *
 */
public class MyRunnable implements Runnable {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public void run() {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {

            //synchronizing the critical section
            //monitor: current instance
            synchronized (this){
                count++; //increment count
            }

        }
        long processingTime = System.currentTimeMillis() - start;

//        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
//                + "|processing_time: " + processingTime + "|value of count at the end of the loop: " + count);
    }
}
