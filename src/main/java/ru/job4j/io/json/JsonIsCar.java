package ru.job4j.io.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonIsCar {
    public static void main(String[] args) {
        final Car car = new Car(false, 140, "BMW X2"
                , new Engine(177), "Yellow", "Black");
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        final String carJson = "{"
                + "\"sportCar\":false,"
                + "\"speedCar\":140,"
                + "\"model\":\"BMW X2\","
                + "\"engine\":"
                + "{"
                    + "\"power\":\"177\""
                + "},"
                + "\"colors\":"
                    + "[\"Yellow\",\"Black\"]"
                + "}";
        final Car carJ = gson.fromJson(carJson, Car.class);
        System.out.println(carJ);
    }
}
