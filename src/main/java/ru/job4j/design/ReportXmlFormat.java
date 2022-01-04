package ru.job4j.design;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXmlFormat implements Report {

    private final Store store;

    public ReportXmlFormat(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String str = null;
        Marshaller marshaller = getMarshaller();
        try (StringWriter writer = new StringWriter()) {
                for (Employee employee : store.findBy(filter)) {
                    marshaller.marshal(employee, writer);
                }
                str = writer.getBuffer().toString();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Marshaller getMarshaller() {
        Marshaller marshaller = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException jaxb) {
            jaxb.printStackTrace();
        }
        return marshaller;
    }
}
