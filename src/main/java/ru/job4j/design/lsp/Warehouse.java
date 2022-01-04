package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> storage = new ArrayList<>();

    public List<Food> getFood(String name) {
        List<Food> rsl = new ArrayList<>();
        storage.stream()
                .filter(f -> f.getName().equals(name))
                .forEach(rsl::add);
        return rsl;
    }


    @Override
    public void addFoodInStorage(Food food) {
        long nowMinusCreated = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long expiryMinusCreated = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long percent = nowMinusCreated > expiryMinusCreated ?
                (nowMinusCreated / expiryMinusCreated + nowMinusCreated % expiryMinusCreated) * 100 
                : (nowMinusCreated % expiryMinusCreated) * 100;
        if (percent >= 25) {
            throw new IllegalArgumentException("Incorrect storage location");
        }
        storage.add(food);
    }
}
