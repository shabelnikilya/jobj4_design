package ru.job4j.ioExam;

import ru.job4j.io.ArgsName;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.BiPredicate;

public class ValidArgsName implements CheckPairKeyValue {
    private final ArgsName args;
    private final Map<String, BiPredicate<Path, String>> pair;

    public ValidArgsName(ArgsName args, Map<String, BiPredicate<Path, String>> pair) {
        this.args = args;
        this.pair = pair;
    }

    public String get(String key) {
        checkValidPair();
        return args.get(key);
    }

    @Override
    public void checkValidPair() {
        if (args.get("t") == null || args.get("n") == null || args.get("d") == null || args.get("o") == null) {
            throw new IllegalArgumentException(
                    "Проверьте все введенные пары ключе-значение(раскладку):" + System.lineSeparator() +
                    "d - директория;" + System.lineSeparator() +
                    "n - имя файла, маска, либо регулярное выражение;" + System.lineSeparator() +
                    "t - типо поиска(mask, name, regex)" + System.lineSeparator() +
                    "o - имя файла, в который записывается результат"
            );
        }
        File file = new File(args.get("d"));
        if (!file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException(
                    "Директория, в которой осуществляется " +
                    "поиск не существует или указана ссылка на файл. Проверьте значение ключа - d!"
            );
        }
        if (args.get("t") == null || !pair.containsKey(args.get("t"))) {
            throw new IllegalArgumentException(
                    "Некорректное значение ключа - t. " + System.lineSeparator() +
                    "Доступны только следующие значения: mask, regex, name."
            );
        }
        if (args.get("t").equals("mask") && !args.get("n").contains("*")) {
            throw new IllegalArgumentException("В ключе - n, отсутствует символ - *");
        }
    }
}
