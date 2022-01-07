package ru.job4j.design.lsp;

import java.util.Calendar;

public interface Storage {

    boolean addFoodInStorage(Food food);

    boolean accept(Food food);

     default double percentExpirationProduct(Food food) {
        long nowMinusCreated = Calendar.getInstance().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long expiryMinusCreated = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        return (double) nowMinusCreated * 100 / expiryMinusCreated;
    }
}
