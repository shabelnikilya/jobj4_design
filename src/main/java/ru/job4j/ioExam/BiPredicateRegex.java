package ru.job4j.ioExam;

import java.nio.file.Path;
import java.util.function.BiPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiPredicateRegex implements BiPredicate<Path, String> {

    @Override
    public boolean test(Path path, String str) {
        Pattern pattern = Pattern.compile(str, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(path.getFileName().toString());
        return matcher.matches();
    }
}
