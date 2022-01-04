package ru.job4j.design;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportXmlFormatTest {
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    @Test
    public void generateReportInXmlFormat() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report report = new ReportXmlFormat(store);
        String expected =String.format(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" //+ //System.lineSeparator()
                +  "<Employee>\n" //+ System.lineSeparator()
                        + "    <name>Ivan</name>\n" //+ System.lineSeparator()
                        + "    <hired>%s</hired>\n" //+ System.lineSeparator()
                        + "    <fired>%s</fired>\n" //+ System.lineSeparator()
                        + "    <salary>100.0</salary>\n" //+ System.lineSeparator()
                + "</Employee>\n",
                formatter.format(worker.getHired().getTime()),
                formatter.format(worker.getFired().getTime()));
        assertThat(report.generate(x -> true), is(expected));
    }
}