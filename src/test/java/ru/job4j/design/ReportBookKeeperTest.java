package ru.job4j.design;

import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportBookKeeperTest {

    @Test
    public void generateReportForBookKeeper() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportBookKeeper(store);
        String expect = "Name; Hired; Fired; Salary(in dollars);" +
                System.lineSeparator() +
                worker.getName() + ";" +
                worker.getHired() + ";" +
                worker.getFired() + ";" +
                worker.getSalary() / 80 + ";" +
                System.lineSeparator();
        assertThat(engine.generate(em -> true), is(expect));
    }
}