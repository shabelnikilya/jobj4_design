package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterUser {

    public static List<User> addUser(int age, String ... name) {
        List<User> user = new ArrayList<>();
        for (String n : name) {
            user.add(new User(age++, n));
        }
        return user;
    }

    public List<User> filterUser(List<User> user, Predicate<User> pr) {
        return user.stream()
                .filter(pr)
                .collect(Collectors.toList());
    }
}
