package ru.job4j.ioExam;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import static java.nio.file.FileVisitResult.CONTINUE;

public class FilterFile extends SimpleFileVisitor<Path> {
    private final List<Path> files = new ArrayList<>();
    private final BiPredicate<Path, String> pred;
    private final String findName;

    public FilterFile(BiPredicate<Path, String> pred, String findName) {
        this.pred = pred;
        this.findName = findName;
    }

    public List<Path> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (pred.test(file, findName)) {
            files.add(file);
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }
}
