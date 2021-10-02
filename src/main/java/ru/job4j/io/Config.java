package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(
                new FileReader(path))) {
           List<String> l =  read.lines().filter(x -> !"".equals(x) && x.charAt(0) != '#')
                    .collect(Collectors.toList());
           for (String kAndV : l) {
               if (kAndV.charAt(0) == '=' || kAndV.indexOf('=') == -1) {
                   throw new IllegalArgumentException();
               }
               values.put(kAndV.split("=")[0], kAndV.split("=")[1]);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
