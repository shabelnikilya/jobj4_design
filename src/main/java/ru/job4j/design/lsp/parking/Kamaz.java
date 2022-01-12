package ru.job4j.design.lsp.parking;

public class Kamaz implements Car{
    private String name;
    private int size;

    public Kamaz(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

}
