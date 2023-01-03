package Parallelism;

public class DecreaserSynchronized implements Runnable {
    private static final Object countLock = new Object();
    static int count = 1000000;
    private static int taskCount = 0;
    private final int id = taskCount++;
    private int iterations = 0;

    @Override
    public void run() {
        while (DoIteration()){};
        System.out.println("id: " + id + "; iterations:" + iterations);
    }

    private boolean DoIteration() {
        synchronized (countLock) {
            if (count > 0) {
                count--;
                iterations++;
                if (count % 100000 == 0) {
                    System.out.println("id: " + id + "; count:" + count);
                }
                return true;
            } else return false;
        }
    }
}
