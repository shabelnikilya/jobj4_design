package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final int sizeTrash = 50;
    private final List<Food> storage = new ArrayList<>(sizeTrash);

    @Override
    public boolean addFoodInStorage(Food food) {
        long percent = percentExpirationProduct(food);
        if (percent <= 100 || !accept(food)) {
            return false;
        }
        return storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return storage.size() < sizeTrash;
    }
}
