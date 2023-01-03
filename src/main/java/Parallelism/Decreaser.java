package Parallelism;

public class Decreaser implements Runnable{
    static  int count = 100000;
    private static int taskCount = 0;
    private final int id = taskCount++;
    private int iterations = 0;
    @Override
    public void run() {
        while (count > 0)
        {
            count--;
            iterations++;
            if (count % 100000 == 0){
                System.out.println("id: "+id+"; count:"+count);
            }
        }
        System.out.println("id: "+id+"; iterations:"+iterations);
    }
}
