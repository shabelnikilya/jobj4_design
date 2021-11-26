package ru.job4j.ood.lsp;

import java.util.List;

public class ShelterInMoscow extends  DogShelter {
    @Override
    public List<Animals> allAnimals() {
        return super.allAnimals();
    }

    @Override
    public void addDogs(Animals cat) {
        dogs.add(cat);
    }
}
