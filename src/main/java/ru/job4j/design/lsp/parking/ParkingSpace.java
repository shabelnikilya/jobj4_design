package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace implements Parking {
    private final List<Car> passengerCar;
    private final List<Car> truck;

    public ParkingSpace(int passengerCarsPlace, int truckPlace) {
        passengerCar = new ArrayList<>(passengerCarsPlace);
        truck = new ArrayList<>(truckPlace);
    }

    @Override
    public boolean parkingCar(Car car) {
        return false;
    }
}
