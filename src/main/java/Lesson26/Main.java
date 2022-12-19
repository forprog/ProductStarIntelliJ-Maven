package Lesson26;

public class Main {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();
        Thread threadRunnableExample = new Thread(new RunnableExample());
        System.out.println("begin");

        threadExample.start();
        threadRunnableExample.start();

        try {
            threadExample.join();
            threadRunnableExample.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
