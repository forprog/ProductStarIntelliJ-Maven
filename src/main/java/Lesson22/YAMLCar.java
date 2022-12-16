package Lesson22;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YAMLCar {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();
        engine.setHp(250);

        Car miura = new Car("Miura",1966,engine);

        File file = new File("miura.yaml");

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue(file, miura);

        Car newMiura = objectMapper.readValue(file,Car.class);
        System.out.println(newMiura.getName());
    }
}
