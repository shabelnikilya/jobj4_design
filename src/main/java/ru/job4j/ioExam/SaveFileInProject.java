package ru.job4j.ioExam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class SaveFileInProject implements OutSaveFile {
    private final String link;

    public SaveFileInProject(String link) {
        this.link = link;
    }

    @Override
    public void saveToPlaceFile(List<Path> files) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(link)))) {
            files.forEach(out::println);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
