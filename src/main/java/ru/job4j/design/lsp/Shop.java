package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private final List<Food> storage = new ArrayList<>();

    @Override
    public boolean addFoodInStorage(Food food) {
        return accept(food) && storage.add(correctPrice(food));
    }

    @Override
    public boolean accept(Food food) {
        return percentExpirationProduct(food) > 25;
    }

    public Food correctPrice(Food food) {
        double percent = percentExpirationProduct(food);
        if (percent > 75 && percent <= 100) {
            food.setPrice(food.getPrice() - food.getPrice() * food.getDiscount() / 100);
        }
        return food;
    }
}
