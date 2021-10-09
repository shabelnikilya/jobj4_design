package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    public void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. " +
                    "Usage java -jar ArgsName.jar ROOT_FOLDER.");
        }
        for (String in : args) {
            String[] splitIn = in.split("=");
            if (splitIn.length < 2 || splitIn[0].charAt(0) != '-') {
                throw new IllegalArgumentException("Incorrect entry of a key / value pair");
            }
            values.put(splitIn[0].substring(1), splitIn[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
