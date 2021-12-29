package ru.job4j.design;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {
    private final Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    public static List<Employee> sortStore(List<Employee> in) {
        return in.stream()
                .sorted((x, y) -> Double.compare(y.getSalary(), x.getSalary()))
                .collect(Collectors.toList());
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : sortStore(store.findBy(filter))) {
            if (filter.test(employee)) {
                text.append(employee.getName()).append(";")
                        .append(employee.getHired()).append(";")
                        .append(employee.getFired()).append(";")
                        .append(employee.getSalary()).append(";")
                        .append(System.lineSeparator());
            }
        }
        return text.toString();
    }
}
