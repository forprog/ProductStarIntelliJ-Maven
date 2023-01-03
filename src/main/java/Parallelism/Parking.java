package Parallelism;


public class Parking {
    private static final boolean[] PARKING_PLACES = new boolean[5];
    // определите ваш семафор

    public static void main(String[] args) throws InterruptedException {
        // запустите процесс парковки
    }

    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            // здесь ваше решение
        }
    }
}