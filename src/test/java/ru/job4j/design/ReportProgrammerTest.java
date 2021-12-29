package ru.job4j.design;

import org.junit.Test;
import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportProgrammerTest {

    @Test
    public void generateReportForProgrammer() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder();
        ReportProgrammer.getHtmlTextBeforeAdd(expect, System.lineSeparator());
        expect.append("            <tr>").append(System.lineSeparator())
                .append("                <td>Ivan</td>").append(System.lineSeparator())
                .append(String.format("                <td>%s</td>", now.getTime())).append(System.lineSeparator())
                .append(String.format("                <td>%s</td>", now.getTime())).append(System.lineSeparator())
                .append("                <td>100.0</td>").append(System.lineSeparator())
                .append("            </tr>").append(System.lineSeparator());
        ReportProgrammer.afterAddEmployees(expect, System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}