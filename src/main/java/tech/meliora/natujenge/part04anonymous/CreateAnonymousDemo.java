package tech.meliora.natujenge.part04anonymous;

import tech.meliora.natujenge.part03runnable.MyAccountManager;

import java.time.LocalTime;

/**
 * Objective: Create a thread using Runnable interface
 * <p>
 *     A runnable is an object instance that provides some code block that can be run in a Java Thread context.
 *     When creating a thread, a developer can pass a runnable to the Thread constructor.
 *     In this case, the run() method defined in the runnable class will be target of execution.
 * <p>
 *
 * <p>
 *     Why uses Runnable instead of extending Thread? In java a class can only extend one Class
 *     but a class can implement many interfaces.
 *
 *     However, you can have situations where you class like AccountManager thread extends AbstractManager
 *     or MyFrame extends JFrame but you still need it to have a thread that does some background work e.g
 *
 *      AccountManager - flushing the data in the account manager to disk or a db
 *      MyFrame - drawing some images on the screen after every 30 milliseconds.
 *
 *
 *     From experience, always use Runnable unless you have a special case where you need to
 *     override some behavior in the Thread class.
 *     In my development life, I have not encountered a scenario where I need to do this.
 *
 * </p>
 */
public class CreateAnonymousDemo {

    public static void main(String[] args) {

        //this line will be printed by the main thread...
        // we expect blow output:
        // 06:22:05.766|main|this is my first line in my main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //Create a Thread instance and using anonymous class
        //this is just a quick way of implement runnable in a very short time
        // 06:36:29.536|my-anonymous-thread|inside the anonymous inner class method
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|inside the anonymous inner class method");
            }
        }, "my-anonymous-thread");

        myThread.start(); // you still have to call start method

        //you can also create a thread as below
        // no need to have a reference to the thread object, you can invoke start() method
        // output: 06:36:29.535|my-anonymous-thread-2|inside the anonymous inner class method - second approach

        // Note: Line 48 and 68 are being executed in different threads...
        // any of the lines could be executed before the other based on the thread scheduler
        // Java does not guarantee which thread runs first on the CPU...
        // you need to understand this as the developer -
        // it is possible for a thread to starved from CPU time (it does not get a chance to run on a CPU)
        // we will be covering more challenges of threads in later stages
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                        + "|inside the anonymous inner class method - second approach");
            }
        }, "my-anonymous-thread-2").start();


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my last line in my main method");

    }
}
