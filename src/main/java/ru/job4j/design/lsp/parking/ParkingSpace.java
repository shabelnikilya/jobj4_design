package ru.job4j.design.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace implements Parking {
    private int passengerCarsPlace;
    private int truckPlace;
    private final List<Car> passengerCarPark = new ArrayList<>(passengerCarsPlace);
    private final List<Car> truckPark = new ArrayList<>(truckPlace);
    private int numberTruckCars = 0;
    private int numberPassengerCars = 0;

    public ParkingSpace(int passengerCarsPlace, int truckPlace) {
        this.passengerCarsPlace = passengerCarsPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean parkingCar(Car car) {
        boolean park = false;
        if (acceptPassengerCars(car)) {
            numberPassengerCars++;
            park = passengerCarPark.add(car);
        } else if (acceptTruckToTruckPark(car)) {
            numberTruckCars++;
            park = truckPark.add(car);
        } else if (acceptTruckToPassengerCarPark(car)) {
            numberTruckCars++;
            park = addTruckToPassengerCarPark(car);
        }
        return park;
    }

    public boolean acceptPassengerCars(Car car) {
        return car.getSize() == 1 && passengerCarsPlace > passengerCarPark.size();
    }

    public boolean acceptTruckToTruckPark(Car car) {
        return car.getSize() != 1 && truckPlace > truckPark.size()
                || passengerCarsPlace >= passengerCarPark.size() + car.getSize();
    }

    public boolean acceptTruckToPassengerCarPark(Car car) {
        return car.getSize() != 1 && truckPlace > truckPark.size()
                || passengerCarsPlace >= passengerCarPark.size() + car.getSize();
    }

    public boolean addTruckToPassengerCarPark(Car car) {
        int inceptionSize = passengerCarPark.size();
        for (int i = 0; i < car.getSize(); i++) {
            passengerCarPark.add(car);
        }
        return passengerCarPark.size() - car.getSize() == inceptionSize;
    }

    public int getNumberTruckCars() {
        return numberTruckCars;
    }

    public int getNumberPassengerCars() {
        return numberPassengerCars;
    }
}
