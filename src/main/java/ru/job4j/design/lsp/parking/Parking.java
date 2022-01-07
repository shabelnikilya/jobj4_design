package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements ParkingSpace{
    private final List<Car> passengerCar;
    private final List<Car> truck;

    public Parking(int passengerCarsPlace, int truckPlace) {
        passengerCar = new ArrayList<>(passengerCarsPlace);
        truck = new ArrayList<>(truckPlace);
    }

    @Override
    public boolean parking(Car car) {
        return false;
    }
}
