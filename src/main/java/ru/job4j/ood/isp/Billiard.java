package ru.job4j.ood.isp;

public class Billiard implements Balls {


    @Override
    public void inflateBall() {
    }

    @Override
    public String colorBall() {
        return "белый";
    }

    @Override
    public int sizeBall() {
        return 10;
    }

    @Override
    public String kindOfSports() {
        return "бильярд";
    }
}
