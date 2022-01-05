package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> storage = new ArrayList<>();

    @Override
    public boolean addFoodInStorage(Food food) {
        return accept(food) && storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return percentExpirationProduct(food) < 25;
    }
}
