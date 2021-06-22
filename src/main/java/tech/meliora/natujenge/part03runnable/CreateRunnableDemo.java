package tech.meliora.natujenge.part03runnable;

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
public class CreateRunnableDemo {

    public static void main(String[] args) {

        //this line will be printed by the main thread...
        // we expect blow output:
        // 06:22:05.766|main|this is my first line in my main method
        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this is my first line in my main method");

        //Create a Thread instance and pass a runnable instance
        // we will name the thread - if we do not name the thread, the JVM will assign our Thread-X name
        // output: 06:22:05.773|account-manager-thread|inside the MyAccountManager.run() method
        MyAccountManager myAccountManager = new MyAccountManager();
        Thread myThread = new Thread(myAccountManager, "account-manager-thread");
        myThread.start();


        System.out.println(LocalTime.now().toString() + "|" + Thread.currentThread().getName()
                + "|this line is inside the MyThread.run() method, I am about to get into an endless loop");

    }
}
