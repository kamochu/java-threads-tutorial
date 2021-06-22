package tech.meliora.natujenge.part14state;

import java.time.LocalTime;
import java.util.LinkedList;

public class Consumer implements Runnable {
    private LinkedList<String> list;
    int interval = 1000;

    public Consumer(LinkedList<String> list, int interval) {
        this.list = list;
        this.interval = interval;
    }

    @Override
    public void run() {

        while (true) {

            try {
                String message = consume();

                synchronized (list){
                    list.notifyAll();
                }

//                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
//                        + "|consumed: " + message);

                Thread.sleep(interval);

            } catch (InterruptedException ex) {
                //bring the thread to an end, a log can be added here...
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|thread interrupted. ConsumerThread about to die");
                break;
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

    }


    private String consume() throws InterruptedException {

        synchronized (list) {
            //wait for list to have a message
            while (list.isEmpty()) {
                list.wait();
            }
//            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
//                    + "|woken up, is there a message");

            //check if the list is empty again
            //why? two threads might be woken at the same time - producer uses notifyAll
            if (list.isEmpty()) {
                return consume();
            } else {
                return list.remove();
            }
        }

    }
}
