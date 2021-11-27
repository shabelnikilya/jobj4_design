package ru.job4j.ood.isp;

public class Football implements Balls {
    @Override
    public void inflateBall() {
        System.out.println("мячик надут");
    }

    @Override
    public String colorBall() {
        return "черно-белый";
    }

    @Override
    public int sizeBall() {
        return 45;
    }

    @Override
    public String kindOfSports() {
        return "Футбол";
    }
}
