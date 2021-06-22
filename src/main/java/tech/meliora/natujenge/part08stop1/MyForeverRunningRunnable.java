package tech.meliora.natujenge.part08stop1;

import java.time.LocalTime;

public class MyForeverRunningRunnable implements Runnable {

    private boolean stopRequested;


    public boolean isStopRequested() {
        return stopRequested;
    }

    /**
     * We have introduced synchronized
     */
    public synchronized void requestStop() {
        this.stopRequested = true;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000); //sleep 1000ms = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|inside the MyForeverRunningRunnable.run() method");

            if (this.stopRequested) {

                //you can close any resources being used by the thread e.g. db connections, etc.

                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|the thread has been stopped");

                //exit the while true block and terminate the thread
                break;
            }
        }


//        while (!stopRequested){
//
//            try {
//                Thread.sleep(500); //sleep 500ms
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
//                    + "|inside the MyForeverRunningRunnable.run() method");
//
//        }
//
//        // you can close resources in this thread
//
//        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
//                + "|the thread has been stopped");

    }
}
