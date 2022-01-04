package ru.job4j.design.lsp;

public class ControllQuality {

    private Storage storage;

    public ControllQuality(Storage storage) {
        this.storage = storage;
    }

    public void sortFoodOnStorage(Food food) {
        storage.addFoodInStorage(food);
    }
}
