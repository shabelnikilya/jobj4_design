package ru.job4j.design;

import java.util.function.Predicate;

public class ReportBookKeeper implements Report {
    private final Store store;

    public ReportBookKeeper(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary(in dollars);").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            if (filter.test(employee)) {
                text.append(employee.getName()).append(";")
                        .append(employee.getHired()).append(";")
                        .append(employee.getFired()).append(";")
                        .append(employee.getSalary() / 80).append(";")
                        .append(System.lineSeparator());
            }
        }
        return text.toString();
    }
}
