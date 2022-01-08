package ru.job4j.design.lsp.parking;

public class MazdaPassenger implements Car{
    private final String name;
    private final int size = 1;

    public MazdaPassenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
