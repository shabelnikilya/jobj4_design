package ru.job4j.ood.dip;

import java.io.*;

public class WriteFile {

    public void write(FileReader in, String link) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(link)))) {
            out.println(in.read());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}