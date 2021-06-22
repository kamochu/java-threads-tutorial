package tech.meliora.natujenge.part10synchronized5;

public class StaticCounter {

    static int a;

    /**
     * ensure that no one instantiates the class
     */
    private StaticCounter() {
    }


    /**
     * Qtn? Do we need to synchronize the getCounter method?
     *
     * @return
     */
    public static int getCounter() {
        return a;
    }

    /**
     * We need to ensure that only one thread is able to synchronize the block
     * <p>
     * Uses the same monitor as below block:
     * synchronized(StaticCounter.class){
     * a++;
     * }
     * <p>
     * Qtn? When should we use sync method?
     */
    public  static void increment() {
        synchronized(StaticCounter.class){
            a++;
        }
    }

}
