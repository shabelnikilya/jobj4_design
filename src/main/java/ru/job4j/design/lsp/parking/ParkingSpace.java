package ru.job4j.design.lsp.parking;

public interface ParkingSpace {

    boolean accept();
    boolean add();
    boolean outCar();
}
