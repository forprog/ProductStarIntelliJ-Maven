package Lesson22;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeCarToFile();

        readCarFromFile();
    }

    private static void readCarFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("car.ser"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        Car car = (Car) ois.readObject();
        System.out.println(car.getName());
    }

    private static void writeCarToFile() throws IOException {
        Engine engine1 = new Engine();
        engine1.setHp(150);

        Car fordFocus = new Car("Ford focus",2020,engine1);

        FileOutputStream fos = new FileOutputStream("car.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(fordFocus);
        oos.close();
    }
}
