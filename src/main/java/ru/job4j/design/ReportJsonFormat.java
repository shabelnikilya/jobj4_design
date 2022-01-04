package ru.job4j.design;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Predicate;

public class ReportJsonFormat implements Report {
    private final Store store;

    public ReportJsonFormat(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder str = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        str.append(gson.toJson(store.findBy(filter)));
        return str.toString();
    }
}
