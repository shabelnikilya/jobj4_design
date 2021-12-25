package ru.job4j.ioExam;

import java.nio.file.Path;
import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class BiPredicateMask implements BiPredicate<Path, String> {

    @Override
    public boolean test(Path path, String str) {
        boolean maskResult;
        String nameFile = path.getFileName().toString();
        if (str.charAt(0) == '*') {
            maskResult = nameFile.endsWith(str.substring(1));
        } else if (str.charAt(str.length() - 1) == '*') {
            maskResult = nameFile.startsWith(str.substring(0, str.length() - 1));
        } else {
            maskResult = nameFile.endsWith(str.split(Pattern.quote("*"))[1])
                    &&  nameFile.startsWith(str.split(Pattern.quote("*"))[0]);
        }
        return maskResult;
    }
}
