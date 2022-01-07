package ru.job4j.design.isp;

import java.util.*;

public class ContextMenu {
    private final List<ShowMenu> out;
    private final ReadMenu read;

    public ContextMenu(List<ShowMenu> out, ReadMenu read) {
        this.out = out;
        this.read = read;
    }

    public void menuOutputToConsole() {
        out.stream()
                .sorted(Comparator.comparing(ShowMenu::textMenu))
                .forEach(ShowMenu::showMenuTask);
        System.out.println("Введите пункт задачи! Например: 1.1. или 1.2.1.");
        String answers = read.readAnswers();
        out.stream()
                .filter(menu -> menu.textMenu().equals(read.correctAnswers(answers)))
                .findFirst()
                .orElse(new IncorrectInput("Не корректный ввод пункта меню")).showMenuTask();
    }

    public static void main(String[] args) {
        List<ShowMenu> e = List.of(new TaskMenuFirst("Задача 1.1."),
                new TaskMenuSecond("Задача 1.1.3."),
                new TaskMenuThird("Задача 1.1.2."));
        ReadMenu read = new ReadTextMenu();
        ContextMenu context = new ContextMenu(e, read);
        context.menuOutputToConsole();
    }
}
