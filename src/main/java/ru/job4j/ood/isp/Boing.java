package ru.job4j.ood.isp;

public class Boing implements Airplane {

    @Override
    public int speed() {
        return 370;
    }

    @Override
    public String colorPlane() {
        return "белый";
    }

    @Override
    public String nameCompany() {
        return "Аэрофлот";
    }

    @Override
    public int amountPassengers() {
        return 200;
    }
}
