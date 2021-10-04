package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean trouble = false;
            String line = reader.readLine();
            while (line != null) {
                String[] lineSplit = line.split(" ");
                if (("400".equals(lineSplit[0]) && !trouble)
                        || ("500".equals(lineSplit[0]) && !trouble)) {
                    out.print(lineSplit[1] + ";");
                    trouble = true;
            } else if (trouble && !"400".equals(lineSplit[0])
                        && !"500".equals(lineSplit[0]))  {
                    out.println(lineSplit[1] + ";");
                    trouble = false;
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./server_source.txt"
                , "./target.txt");
        analizy.unavailable("./server_source_sec.txt"
                , "./target_sec.txt");
        try (BufferedReader out = new BufferedReader(
                new FileReader("./target.txt"));
             BufferedReader outSecond = new BufferedReader(
                     new FileReader("./target_sec.txt"))) {
            out.lines().forEach(System.out::println);
            System.out.println();
            outSecond.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}