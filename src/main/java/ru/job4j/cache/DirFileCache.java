package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        AbstractCache<String, String> loadCache = new DirFileCache(cachingDir);
        StringBuilder textFile = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader(cachingDir + "\\" + key))) {
            in.lines().forEach(textFile::append);
            loadCache.put(key, textFile.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textFile.toString();
    }
}
