package Parallelism;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable{
    @Override
    public void run() {
        System.out.println("Starting ADaemon");
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exited via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }

}
public class DaemonsDontRunFinally{
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        //t.setDaemon(true);
        t.start();
    }
}