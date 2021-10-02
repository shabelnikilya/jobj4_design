package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean trouble = false;
            List<String> s = reader.lines()
                    .collect(Collectors.toList());
            for (String in : s) {
                if (("400".equals(in.split(" ")[0]) && !trouble)
                        || ("500".equals(in.split(" ")[0]) && !trouble)) {
                    out.print(in.split(" ")[1] + ";");
                    trouble = true;
                } else if (trouble && !"400".equals(in.split(" ")[0])
                        && !"500".equals(in.split(" ")[0]))  {
                    out.println(in.split(" ")[1] + ";");
                    trouble = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("D:\\file_java_io\\server_source.txt"
                , "D:\\file_java_io\\target.txt");
        analizy.unavailable("D:\\file_java_io\\server_source_sec.txt"
                , "D:\\file_java_io\\target_sec.txt");
        try (BufferedReader out = new BufferedReader(
                new FileReader("D:\\file_java_io\\target.txt"));
             BufferedReader outSecond = new BufferedReader(
                     new FileReader("D:\\file_java_io\\target_sec.txt"))) {
            out.lines().forEach(System.out::println);
            System.out.println();
            outSecond.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}