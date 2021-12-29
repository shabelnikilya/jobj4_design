package ru.job4j.design;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {
    private final Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> filterEmployees = store.findBy(filter);
        filterEmployees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : filterEmployees) {
                text.append(employee.getName()).append(";")
                        .append(employee.getHired()).append(";")
                        .append(employee.getFired()).append(";")
                        .append(employee.getSalary()).append(";")
                        .append(System.lineSeparator());
        }
        return text.toString();
    }
}
