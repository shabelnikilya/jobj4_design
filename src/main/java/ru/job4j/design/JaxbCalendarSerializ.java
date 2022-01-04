package ru.job4j.design;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JaxbCalendarSerializ extends XmlAdapter<String, Calendar> {
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

    @Override
    public Calendar unmarshal(String s) throws Exception {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(formatter.parse(s));
        return calendar;
    }

    @Override
    public String marshal(Calendar calendar) {
        return formatter.format(calendar.getTime());
    }
}
