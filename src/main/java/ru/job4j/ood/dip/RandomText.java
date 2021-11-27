package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomText {

    public List<String> readText(String text) {
        String[] words = text.split(" ");
        return new ArrayList<>(Arrays.asList(words));
    }

    public void showRandomText(String text) {
        List<String> show = readText(text);
        Collections.shuffle(show);
        show.forEach(System.out::println);
    }
}
