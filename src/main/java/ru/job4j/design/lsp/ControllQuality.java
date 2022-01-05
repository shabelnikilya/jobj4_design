package ru.job4j.design.lsp;

import java.util.List;
import java.util.Optional;

public class ControllQuality {

    private final List<Storage> storage;

    public ControllQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public boolean sortFoodOnStorage(Food food) {
        Optional<Storage> productSortToStorage = storage.stream()
                .filter(st -> st.addFoodInStorage(food))
                .findFirst();
        return productSortToStorage.isPresent();
    }
}
