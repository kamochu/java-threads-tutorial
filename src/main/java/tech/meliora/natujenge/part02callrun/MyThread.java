package tech.meliora.natujenge.part02callrun;

import java.time.LocalTime;

public class MyThread extends Thread {

    public MyThread() {
    }

    public MyThread(Runnable runnable) {
        super(runnable);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public MyThread(String s) {
        super(s);
    }

    public MyThread(ThreadGroup threadGroup, String s) {
        super(threadGroup, s);
    }

    public MyThread(Runnable runnable, String s) {
        super(runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s) {
        super(threadGroup, runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l) {
        super(threadGroup, runnable, s, l);
    }

    /**
     * We are overriding the run method from the parent class Thread
     * Any code block inside this method will be executed when the thread is started.
     * <p>
     * This method should NOT be invoked/called explicitly by the developer.
     * The developer should invoke Thread.start() method
     * which will create a Java Thread and invoke the run method implicitly.
     */
    public void run() {

        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this line is inside the MyThread.run() method, I am about to get into an endless loop");

        int i =0 ;
        while (true){
            //do nothing

            // i want to print a line after every 10,000 iterations
            if( (i%10000) == 0 ){
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|inside the MyThread.run() method");

                //reset i to avoid integer overflow...  :-)
                i = 0;
            }

            i++;
        }

        // we will never get here - any statement below here will be unreachabe
    }

}
