package ru.job4j.design;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Calendar;
import java.util.Objects;

@XmlRootElement(name="Employee")
@XmlType(propOrder = {"name", "hired", "fired", "salary"})
public class Employee {

    private String name;
    private Calendar hired;
    private Calendar fired;
    private double salary;

    public Employee() {
    }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlJavaTypeAdapter(JaxbCalendarSerializ.class)
    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    @XmlJavaTypeAdapter(JaxbCalendarSerializ.class)
    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee that = (Employee) o;
        return Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name)
                && Objects.equals(hired, that.hired) && Objects.equals(fired, that.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }
}
