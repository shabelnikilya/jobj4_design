package ru.job4j.ood.isp;

public class FighterPlane implements Airplane {

    @Override
    public int speed() {
        return 500;
    }

    @Override
    public String colorPlane() {
        return "черный";
    }

    @Override
    public String nameCompany() {
        return "Вооруженные силы РФ";
    }

    @Override
    public int amountPassengers() {
        return 0;
    }
}
