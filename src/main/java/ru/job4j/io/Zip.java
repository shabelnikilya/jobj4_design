package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zips = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(target)))) {
            for (File f : sources) {
                if (f.isAbsolute()) {
                    Path zipAbsWay = Paths.get(target.getAbsolutePath());
                    Path fileAbsWay = Paths.get(f.getPath());
                    Path r = zipAbsWay.relativize(fileAbsWay);
                    zips.putNextEntry(new ZipEntry(r.toFile().getPath()));
                } else {
                    zips.putNextEntry(new ZipEntry(f.getPath()));
                }
                BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(f));
                    zips.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArgsName validInputArgs(String[] args) {
        ArgsName a = new ArgsName();
        a.parse(args);
        if (args.length < 3 || !Paths.get(a.get("d")).toFile().exists()) {
            throw new IllegalArgumentException("Root folder is null. " +
                    "Usage java -jar SearchFiles.jar ROOT_FOLDER.");
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        ArgsName getV = validInputArgs(args);
        SearchFiles searcher = new SearchFiles(p -> !p.toFile()
                .getName()
                .endsWith(getV.get("e").substring(1)));
        Files.walkFileTree(Paths.get(getV.get("d")), searcher);
        List<File> in = searcher.getPaths().stream()
                .map(Path::toFile)
                .collect(Collectors.toList());
        packFiles(in, Paths.get(getV.get("o")).toFile());
    }
}
