package ru.job4j.design.lsp.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void parkingAddTwoPassengerCarTrue() {
        Car mazdaSix = new Mazda("mazda 6");
        Car mazdaCX = new Mazda("mazda CX-9");
        ParkingSpace parking = new ParkingSpace(2, 1);
        assertTrue(parking.parkingCar(mazdaSix));
        assertTrue(parking.parkingCar(mazdaCX));
        assertThat(parking.getNumberPassengerCars(), is(2));
    }

    @Test
    public void parkingAddWhenNoPlacePassengerCarsFalse() {
        Car mazdaSix = new Mazda("mazda 6");
        Car mazdaCX = new Mazda("mazda CX-9");
        ParkingSpace parking = new ParkingSpace(1, 1);
        assertTrue(parking.parkingCar(mazdaSix));
        assertFalse(parking.parkingCar(mazdaCX));
        assertThat(parking.getNumberPassengerCars(), is(1));
    }

    @Test
    public void parkingAddOneTruck() {
        Car car = new Kamaz("Kamaz", 3);
        ParkingSpace parking = new ParkingSpace(2, 1);
        assertTrue(parking.parkingCar(car));
        assertThat(parking.getNumberTruckCars(), is(1));
    }

    @Test
    public void parkingAddTwoTruckTrue() {
        Car firstTruck = new Kamaz("Kamaz", 3);
        Car secondTruck = new Kamaz("Kamaz", 2);
        ParkingSpace parking = new ParkingSpace(2, 1);
        assertTrue(parking.parkingCar(firstTruck));
        assertTrue(parking.parkingCar(secondTruck));
        assertThat(parking.getNumberTruckCars(), is(2));
    }

    @Test
    public void parkingAddTwoTruckFalse() {
        Car firstTruck = new Kamaz("Kamaz", 3);
        Car secondTruck = new Kamaz("Kamaz", 2);
        ParkingSpace parking = new ParkingSpace(2, 1);
        assertTrue(parking.parkingCar(secondTruck));
        assertFalse(parking.parkingCar(firstTruck));
        assertThat(parking.getNumberTruckCars(), is(1));
    }

    @Test
    public void parkingAddTwoTruckAndOnePassengerCarFalse() {
        Car firstTruck = new Kamaz("Kamaz", 3);
        Car secondTruck = new Kamaz("Kamaz", 2);
        Car passenger = new Mazda("mazda 6");
        ParkingSpace parking = new ParkingSpace(2, 1);
        assertTrue(parking.parkingCar(firstTruck));
        assertTrue(parking.parkingCar(passenger));
        assertFalse(parking.parkingCar(secondTruck));
        assertThat(parking.getNumberPassengerCars(), is(1));
        assertThat(parking.getNumberTruckCars(), is(1));
    }

    @Test
    public void parkingAddOneTruckAndTwoPassengerCarTrue() {
        Car truck = new Kamaz("Kamaz", 2);
        Car firstPassenger = new Mazda("mazda 6");
        Car secondPassenger = new Mazda("mazda CX");
        ParkingSpace parking = new ParkingSpace(4, 0);
        assertTrue(parking.parkingCar(firstPassenger));
        assertTrue(parking.parkingCar(truck));
        assertTrue(parking.parkingCar(secondPassenger));
        assertThat(parking.getNumberPassengerCars(), is(2));
        assertThat(parking.getNumberTruckCars(), is(1));
    }
}