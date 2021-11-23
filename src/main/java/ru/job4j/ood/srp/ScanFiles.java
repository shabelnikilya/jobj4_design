package ru.job4j.ood.srp;

public interface ScanFiles {
    String readFile(String link);

    void writeFile(String text, String dir);
}
