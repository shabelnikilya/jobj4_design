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
        String expect = "Name; Hired; Fired; Salary;" +
                System.lineSeparator() +
                workerSecond.getName() + ";" +
                workerSecond.getHired() + ";" +
                workerSecond.getFired() + ";" +
                workerSecond.getSalary() + ";" +
                System.lineSeparator() +
                workerFirst.getName() + ";" +
                workerFirst.getHired() + ";" +
                workerFirst.getFired() + ";" +
                workerFirst.getSalary() + ";" +
                System.lineSeparator() +
                workerThird.getName() + ";" +
                workerThird.getHired() + ";" +
                workerThird.getFired() + ";" +
                workerThird.getSalary() + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> em.getName().length() > 3), is(expect));
    }
}