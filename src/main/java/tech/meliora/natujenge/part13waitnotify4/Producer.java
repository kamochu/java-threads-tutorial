package tech.meliora.natujenge.part13waitnotify4;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Producer implements Runnable {

    private LinkedList<String> list;
    int interval = 1000;
    int maxListSize = 10;

    int counter;

    public Producer(LinkedList<String> list, int interval, int maxListSize) {
        this.list = list;
        this.interval = interval;
        this.maxListSize = maxListSize;

        this.counter = 0;
    }

    @Override
    public void run() {

        while (true) {

            try {
                produce();

                Thread.sleep(interval);

            } catch (InterruptedException ex) {
                //bring the thread to an end, a log can be added here...
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|thread interrupted. producer about to die");
                break;
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

    }


    private void produce() throws InterruptedException {

        synchronized (list) {
            //wait for list to have a message
            while (list.size() == this.maxListSize) {
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|list is full, list size " + list.size() + ", waiting");
                list.wait();

                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|notified, list size " + list.size() + "");
            }

            String message = "message-" + counter;

            counter++;

            list.add(message);

            System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                    + "|produced: " + message + "|size: " + list.size());

            //notify other guys
            list.notifyAll();
        }


    }
}
