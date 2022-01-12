package ru.job4j.design.lsp.parking;

public class Mazda implements Car{
    private final String name;
    private final int size = 1;

    public Mazda(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
