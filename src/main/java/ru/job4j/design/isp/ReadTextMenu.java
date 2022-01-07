package ru.job4j.design.isp;

import java.util.Scanner;

public class ReadTextMenu implements ReadMenu{

    @Override
    public String readAnswers() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public String correctAnswers(String answer) {
        return "Задача " + answer;
    }
}
