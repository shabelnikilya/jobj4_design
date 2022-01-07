package ru.job4j.design.isp;

public class IncorrectInput implements ShowMenu {
    private final String text;

    public IncorrectInput(String text) {
        this.text = text;
    }

    @Override
    public String textMenu() {
        return text;
    }

    @Override
    public void showMenuTask() {
        System.out.println(text);
    }
}
