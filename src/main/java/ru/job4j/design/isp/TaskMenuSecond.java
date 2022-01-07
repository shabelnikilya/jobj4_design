package ru.job4j.design.isp;

public class TaskMenuSecond implements ShowMenu {
    private final String text;

    public TaskMenuSecond(String text) {
        this.text = text;
    }

    @Override
    public String textMenu() {
        return text;
    }

    @Override
    public void showMenuTask() {
        System.out.println(correctStringForMenu(text));
    }

}
