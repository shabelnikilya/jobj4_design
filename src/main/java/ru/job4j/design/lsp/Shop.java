package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final int sizeShop = 30;
    private final List<Food> storage = new ArrayList<>(sizeShop);

    @Override
    public boolean addFoodInStorage(Food food) {
        long percent = percentExpirationProduct(food);
        if (percent < 25 || !accept(food)) {
            return false;
        } else if (percent > 75 && percent <= 100) {
            food.setPrice(food.getPrice() - food.getDiscount());
        }
        return storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return storage.size() < sizeShop;
    }
}
