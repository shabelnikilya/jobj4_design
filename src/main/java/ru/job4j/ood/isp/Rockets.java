package ru.job4j.ood.isp;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Rockets implements Magazine {

    @Override
    public String news(String name) {
        return name + "Список новостей журнала Rocket";
    }

    @Override
    public void photoCelebrity(File file, String in) {
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(in.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String joke() {
        return null;
    }

    @Override
    public String tvProgram() {
        return "Список передач на разных каналах";
    }

    @Override
    public String horoscope() {
        return null;
    }
}
