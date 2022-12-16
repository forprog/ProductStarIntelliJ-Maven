package Lesson22;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JasonCar {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();
        engine.setHp(250);

        Car miura = new Car("Miura",1966,engine);

        File file = new File("miura.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(file, miura);

        Car newMiura = objectMapper.readValue(file,Car.class);
        System.out.println(newMiura.getName());
    }
}
