package ru.job4j.design;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportHRTest {

    @Test
    public void generateHrReportWithSort() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        Employee workerSecond = new Employee("Jora", now, now, 120);
        Employee workerThird = new Employee("Kolya", now, now, 90);
        store.add(workerFirst);
        store.add(workerSecond);
        store.add(workerThird);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerSecond.getName()).append(";")
                .append(workerSecond.getHired()).append(";")
                .append(workerSecond.getFired()).append(";")
                .append(workerSecond.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerFirst.getName()).append(";")
                .append(workerFirst.getHired()).append(";")
                .append(workerFirst.getFired()).append(";")
                .append(workerFirst.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerThird.getName()).append(";")
                .append(workerThird.getHired()).append(";")
                .append(workerThird.getFired()).append(";")
                .append(workerThird.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> em.getName().length() > 3), is(expect.toString()));
    }
}