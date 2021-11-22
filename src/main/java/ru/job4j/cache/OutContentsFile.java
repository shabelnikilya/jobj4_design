package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

public class OutContentsFile implements ManyOperation {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void makeOperation(String dir) {
        AbstractCache<String, String> dirFileCache = new DirFileCache(dir);
        System.out.println("Введите имя файла содержимое которого нужно вывести: ");
        String key = scanner.nextLine();
        checkFile(dir + "\\" + key);
        System.out.println("Содержимое файла: " + dirFileCache.get(key));
    }

    public static void checkFile(String dir) {
        File file = new File(dir);
        if (!file.exists() || new File(dir).isDirectory()) {
            throw new IllegalArgumentException("Не корректная ссылка на файл " +
                    "или отсутствует данный файл в директории!");
        }
    }
}
