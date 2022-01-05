package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final int sizeWarehouse = 20;
    private final List<Food> storage = new ArrayList<>(sizeWarehouse);

    @Override
    public boolean addFoodInStorage(Food food) {
        long percent = percentExpirationProduct(food);
        if (percent >= 25) {
            return false;
        }
        return accept(food) && storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return storage.size() < sizeWarehouse;
    }
}
