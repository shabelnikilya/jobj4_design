package ru.job4j.ioExam;

import java.nio.file.Path;
import java.util.function.BiPredicate;

public class BiPredicateName implements BiPredicate<Path, String> {

    @Override
    public boolean test(Path path, String str) {
        return path.getFileName().toString().equals(str);
    }
}
