package ru.job4j.ioExam;

import ru.job4j.io.ArgsName;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.BiPredicate;

public class FindFilesInDir {
    private static final Map<String, BiPredicate<Path, String>> filter = Map.of(
            "mask", new BiPredicateMask(),
            "name", new BiPredicateName(),
            "regex", new BiPredicateRegex()
    );

    public static void validArgs(String[] args) {
        if (args == null || args.length < 4) {
            throw new IllegalArgumentException("Проверьте все ли пары ключ-значение введены");
        }
    }

    public static void main(String[] args) {
        validArgs(args);
        CheckPairKeyValue validArgs = new ValidArgsName(ArgsName.of(args), filter);
        FilterFile filter = new FilterFile(FindFilesInDir.filter.get((validArgs.get("t"))), validArgs.get("n"));
        OutSaveFile save = new SaveFileInProject(validArgs.get("o"));
        try {
            Files.walkFileTree(Paths.get(validArgs.get("d")), filter);
        } catch (IOException io) {
            io.printStackTrace();
        }
        save.saveToPlaceFile(filter.getFiles());
    }
}
