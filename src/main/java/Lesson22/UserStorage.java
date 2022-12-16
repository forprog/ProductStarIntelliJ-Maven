package Lesson22;

import java.io.*;

public class UserStorage {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeUserToFile();

        readUserFromFile();
    }

    private static void readUserFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(new File("user.ser"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user = (User) ois.readObject();
        System.out.println(user.getLogin()+"\n"+user.getPassword());
    }

    private static void writeUserToFile() throws IOException {

        User user = new User("FordFocus","2020");

        FileOutputStream fos = new FileOutputStream("user.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
    }
}
