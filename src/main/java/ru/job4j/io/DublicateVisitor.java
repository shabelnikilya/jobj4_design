package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DublicateVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> findCopy = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty key = new FileProperty(file.toFile().length()
                , file.toFile().getName());
        if (findCopy.containsKey(key)) {
            findCopy.get(key).add(file);

        } else {
            List<Path> val = new ArrayList<>();
            val.add(file);
            findCopy.put(key, val);
        }
        for (FileProperty f : findCopy.keySet()) {
            if (findCopy.get(f).size() > 1) {
                for (Path p : findCopy.get(f)) {
                    System.out.println("Дубликат - " + p);
                }
            }
        }
        return super.visitFile(file, attrs);
    }
}
