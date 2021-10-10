package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        List<String> logs = new ArrayList<>();
        String inceptionDialog = "Введите сообщение боту: ";
        String nothingQuest = "Вы ничего не напечатали, попробуйте еще раз: ";
        System.out.print(inceptionDialog);
        add(logs, inceptionDialog);
        String quest;
            while (!OUT.equals(quest = in.nextLine())) {
                if ("".equals(quest)) {
                    System.out.println(nothingQuest);
                    add(logs, nothingQuest);
                } else if (!STOP.equals(quest)) {
                    String rand = randomAnswers(readPhrases());
                    System.out.println(rand);
                    add(logs, quest, rand);
                } else {
                    add(logs, quest);
                    while (!CONTINUE.equals(quest)) {
                        quest = in.nextLine();
                }
                    System.out.println(inceptionDialog);
                    add(logs, quest, inceptionDialog);
                }
            }
            add(logs, quest);
            saveLog(logs);
    }

    public static String randomAnswers(List<String> in) {
        Collections.shuffle(in);
        return in.get(0);
    }

    public static void add(List<String> withText, String in) {
        withText.add(in);
    }

    public static void add(List<String> withText, String in, String inSecond) {
        withText.add(in);
        withText.add(inSecond);
    }

    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(
                new FileReader(this.botAnswers))) {
            r.lines().forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writeLog = new PrintWriter(
                new FileWriter(this.path, Charset.defaultCharset()))) {
            log.forEach(writeLog::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("logBot.txt", "random.txt");
        cc.run();
    }
}
