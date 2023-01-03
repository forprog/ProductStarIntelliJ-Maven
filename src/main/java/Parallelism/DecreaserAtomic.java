package Parallelism;

import java.util.concurrent.atomic.AtomicInteger;

public class DecreaserAtomic implements Runnable {
    static AtomicInteger count = new AtomicInteger(1000000);
    private static int taskCount = 0;
    private final int id = taskCount++;
    private AtomicInteger iterations = new AtomicInteger(0);

    @Override
    public void run() {
        while (count.get() > 0) {
            DoIteration();
        }
        System.out.println("id: " + id + "; iterations:" + iterations);
    }

    private void DoIteration() {
        count.getAndDecrement();
        iterations.getAndIncrement();
        if (count.get() % 100000 == 0) {
            System.out.println("id: " + id + "; count:" + count);
        }
    }
}
