package ru.job4j.ood.srp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadTxtFile implements ScanFiles {
    @Override
    public String readFile(String link) {
        String text = null;
        try {
            text = Files.readString(Path.of(link));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public void writeFile(String text, String dir) {
        try (PrintWriter out = new PrintWriter(
                                new BufferedWriter(
                                new FileWriter(dir)))) {
            out.print(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
