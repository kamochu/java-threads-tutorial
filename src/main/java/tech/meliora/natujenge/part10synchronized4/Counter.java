package tech.meliora.natujenge.part10synchronized4;

public class Counter {

    int a;

    /**
     * Qtn? Do we need to synchronize the getCounter method?
     *
     * @return
     */
    public int getCounter() {
        return a;
    }

    /**
     * We need to ensure that only one thread is able to synchronize the block
     * <p>
     * Uses the same monitor as below block:
     * synchronized(this){
     * a++;
     * }
     * <p>
     * Qtn? When should we use sync method?
     */
    public synchronized void increment() {
        a++;
    }

}
