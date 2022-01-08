package ru.job4j.design.lsp.parking;

public class KamazTruck implements Car{
    private String name;
    private int size;

    public KamazTruck(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
