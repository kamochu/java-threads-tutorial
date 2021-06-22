package tech.meliora.natujenge.part08stop3;

import java.time.LocalTime;

public class MyForeverRunningRunnable implements Runnable {


    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(1000); //sleep 1000ms = 1 second

                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|inside the MyForeverRunningRunnable.run() method");

                //some methods do not throw interrupted exception
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }

            } catch (InterruptedException e) {
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|thread has been interrupted");

                break;
            }

        }
        //close any resources that need to be closed, open files, connections, etc.

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|the thread has been stopped");

    }
}
