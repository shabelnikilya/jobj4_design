package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class WorkWithUser {
    private List<User> box = new ArrayList<>();
    private int size;

    public void add(User user) {
        box.add(user);
        size++;
    }

    public void deleteUser(int index) {
        box.remove(index);
        size--;
    }
    
    public void showAll() {
        box.forEach(System.out::println);
    }
}
