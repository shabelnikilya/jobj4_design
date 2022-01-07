package ru.job4j.design.isp;

public interface ShowMenu {

    String textMenu();

    void showMenuTask();

    default String correctStringForMenu(String in) {
        String numbers = in.split(" ")[1];
        int howMuchPoint = numbers.split("\\.").length - 1;
        return "----".repeat(Math.max(0, howMuchPoint)) + in;
    }
}
