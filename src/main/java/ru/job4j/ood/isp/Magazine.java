package ru.job4j.ood.isp;

import java.io.File;

public interface Magazine {

    String news(String name);

    void photoCelebrity(File file, String in);

    String joke();

    String tvProgram();

    String horoscope();
}
