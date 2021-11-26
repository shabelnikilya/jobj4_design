package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class DogShelter {

    List<Animals> dogs = new ArrayList<>();

    public List<Animals> allAnimals() {
        return dogs;
    }

    public void addDogs(Animals dog) {
        if (dog.getClass() == Dog.class) {
            dogs.add(dog);
        }
    }
}
