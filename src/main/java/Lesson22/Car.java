package Lesson22;

import java.io.Serializable;

public class Car implements Serializable {
    private final static long serialVersionUID = 1L;
    private String name;
    private int year;
    private int weight;

    public Car(String name, int year, int weight, Engine engine) {
        this.name = name;
        this.year = year;
        this.weight = weight;
        this.engine = engine;
    }

    public Car() {
    }

    public Car(String name, int year, Engine engine) {
        this.name = name;
        this.year = year;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    private Engine engine;
}
