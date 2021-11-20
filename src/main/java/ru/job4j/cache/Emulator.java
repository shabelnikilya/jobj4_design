package ru.job4j.cache;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Emulator {

    public static void showMenu() {
        List<String> menu = List.of(
                "1 - Загрузить содержимое файла в кэш: ",
                "2 - Получить содержимое файла с именем: ",
                "3 - Выход"
        );
        menu.forEach(System.out::println);
    }

    public static String stringScanner() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean selectOperation(int select, String dir) {
        ManyOperation operation = null;
        if (select == 1) {
            operation = new LoadFileInCache();
        } else if (select == 2) {
            operation = new OutContentsFile();
        } else if (select == 3) {
            return false;
        }
        Objects.requireNonNull(operation).makeOperation(dir);
        return true;
    }

    public static int validateFormatNumberMenu(String selectMenu) {
        int select = Integer.parseInt(selectMenu);
        if (select > 3 || select < 1) {
            throw new IllegalArgumentException("Ошибка ввода в меню!");
        }
        return select;
    }

    public static void getValidDirectoryLink(String dir) {
        File file = new File(dir);
            if (!file.exists() || !new File(dir).isDirectory()) {
                throw new IllegalArgumentException("Не корректная директория!");
            }
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        int select;
        boolean run = true;
        while (run) {
            try {
                System.out.println("Укажите кэшируемую дерикторию или введите - 3, для выхода: ");
                String dir = stringScanner();
                if ("3".equals(dir)) {
                    break;
                }
                getValidDirectoryLink(dir);
                showMenu();
                select = validateFormatNumberMenu(stringScanner());
                run = emulator.selectOperation(select, dir);
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
                System.out.println("Не корректный ввод данных. Повторите попытку!");
            }
        }
    }
}
