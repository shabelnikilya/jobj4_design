package ru.job4j.cache;

import java.io.File;
import java.util.Scanner;

public class LoadFileInCache implements ManyOperation {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void makeOperation(String dir) {
        DirFileCache dirFileCache = new DirFileCache(dir);
        System.out.println("Введите имя загружаемого файла: ");
        String key = scanner.nextLine();
        checkFile(dir + "\\" + key);
        System.out.println("Содержимое файла: " + dirFileCache.load(key));
    }

    public static void checkFile(String dir) {
        File file = new File(dir);
        if (!file.exists() || new File(dir).isDirectory()) {
            throw new IllegalArgumentException("Не корректная ссылка на файл " +
                    "или отсутствует данный файл в директории!");
        }
    }
}
