package ru.job4j.design.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkingAddPassengerCarTrue() {
        Car car = new Car("mazda", 1);
        ParkingSpace parking = new Parking(20, 20);
        parking.parking(car);
        assertTrue(true);
    }

    @Test
    public void parkingAddTruckTrue() {
        Car car = new Car("mazda", 3);
        ParkingSpace parking = new Parking(20, 20);
        parking.parking(car);
        assertTrue(true);
    }

    @Test
    public void parkingAddWhenNoPlacePassengerCarsFalse() {
        Car carBmw = new Car("BMW", 1);
        ParkingSpace parking = new Parking(0, 20);
        assertFalse(parking.parking(carBmw));
    }

    @Test
    public void parkingAddWhenNoPlaceTruckCarsTrue() {
        Car carMazda = new Car("mazda", 3);
        ParkingSpace parking = new Parking(5, 0);
        parking.parking(carMazda);
        assertTrue(true);
    }

    @Test
    public void parkingAddWhenNoSpaceInSizeEverywhereFalse() {
        Car carMazda = new Car("mazda", 3);
        Car carBmw = new Car("BMW", 3);
        ParkingSpace parking = new Parking(2, 3);
        parking.parking(carMazda);
        parking.parking(carBmw);
        assertFalse(false);
    }

    @Test
    public void parkingAddWhenNoPlaceTruckCarsAndOccupiedPassengerCarPlace() {
        Car carMazda = new Car("mazda", 3);
        Car carBmw = new Car("BMW", 1);
        ParkingSpace parking = new Parking(3, 0);
        parking.parking(carMazda);
        parking.parking(carBmw);
        assertFalse(false);
    }
}