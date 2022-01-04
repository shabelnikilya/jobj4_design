package ru.job4j.design;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportJsonFormatTest {

    @Test
    public void generateReportInJson() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2021, Calendar.DECEMBER, 12, 10, 1, 55);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportJsonFormat(store);
        String expected =
                    "[{\"name\":\"Ivan\"," +
                            "\"hired\":{\"year\":2021,\"month\":11,\"dayOfMonth\":12," +
                            "\"hourOfDay\":10,\"minute\":1,\"second\":55}," +
                            "\"fired\":{\"year\":2021,\"month\":11,\"dayOfMonth\":12," +
                            "\"hourOfDay\":10,\"minute\":1,\"second\":55}," +
                    "\"salary\":100.0}]";
        assertThat(report.generate(em -> true), is(expected));
    }
}