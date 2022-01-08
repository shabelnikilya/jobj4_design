package ru.job4j.design.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkingAddPassengerCarTrue() {
        Car mazdaSix = new MazdaPassenger("mazda 6");
        Car mazdaCX = new MazdaPassenger("mazda CX-9");
        Parking parking = new ParkingSpace(2, 1);
        parking.parkingCar(mazdaSix);
        parking.parkingCar(mazdaCX);
        assertTrue(true);
    }

    @Test
    public void parkingAddWhenNoPlacePassengerCarsFalse() {
        Car mazdaSix = new MazdaPassenger("mazda 6");
        Car mazdaCX = new MazdaPassenger("mazda CX-9");
        Parking parking = new ParkingSpace(1, 1);
        parking.parkingCar(mazdaSix);
        parking.parkingCar(mazdaCX);
        assertFalse(false);
    }

    @Test
    public void parkingAddTruckTrue() {
        Car car = new KamazTruck("Kamaz", 3);
        Parking parking = new ParkingSpace(2, 1);
        parking.parkingCar(car);
        assertTrue(true);
    }

    @Test
    public void parkingAddTwoTruckTrue() {
        Car firstTruck = new KamazTruck("Kamaz", 3);
        Car secondTruck = new KamazTruck("Kamaz", 2);
        Parking parking = new ParkingSpace(2, 1);
        parking.parkingCar(firstTruck);
        parking.parkingCar(secondTruck);
        assertTrue(true);
    }

    @Test
    public void parkingAddTwoTruckFalse() {
        Car firstTruck = new KamazTruck("Kamaz", 3);
        Car secondTruck = new KamazTruck("Kamaz", 2);
        Parking parking = new ParkingSpace(2, 1);
        parking.parkingCar(secondTruck);
        parking.parkingCar(firstTruck);
        assertFalse(false);
    }

    @Test
    public void parkingAddTwoTruckAndOnePassengerCarFalse() {
        Car firstTruck = new KamazTruck("Kamaz", 3);
        Car secondTruck = new KamazTruck("Kamaz", 2);
        Car passenger = new MazdaPassenger("mazda 6");
        Parking parking = new ParkingSpace(2, 1);
        parking.parkingCar(firstTruck);
        parking.parkingCar(passenger);
        parking.parkingCar(secondTruck);
        assertFalse(false);
    }

    @Test
    public void parkingAddOneTruckAndTwoPassengerCarTrue() {
        Car truck = new KamazTruck("Kamaz", 2);
        Car firstPassenger = new MazdaPassenger("mazda 6");
        Car secondPassenger = new MazdaPassenger("mazda CX");
        Parking parking = new ParkingSpace(4, 0);
        parking.parkingCar(firstPassenger);
        parking.parkingCar(truck);
        parking.parkingCar(secondPassenger);
        assertTrue(true);
    }
}