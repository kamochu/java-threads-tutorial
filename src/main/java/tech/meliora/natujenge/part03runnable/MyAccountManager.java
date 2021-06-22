package tech.meliora.natujenge.part03runnable;

import java.time.LocalTime;

public class MyAccountManager implements Runnable {

    @Override
    public void run() {
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|inside the MyAccountManager.run() method");
    }

}
