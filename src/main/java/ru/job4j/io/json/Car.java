package ru.job4j.io.json;

import java.util.Arrays;

public class Car {
    private boolean sportCar;
    private int speedCar;
    private String model;
    private Engine engine;
    private String[] colors;

    public Car(boolean sportCar, int speedCar, String model, Engine engine, String... colors) {
        this.sportCar = sportCar;
        this.speedCar = speedCar;
        this.model = model;
        this.engine = engine;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "sportCar=" + sportCar +
                ", speedCar=" + speedCar +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", colors=" + Arrays.toString(colors) +
                '}';
    }
}
