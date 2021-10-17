package ru.job4j.io.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="engine")
public class Engine {
    @XmlAttribute
    private int power;

    public Engine() {
    }

    public Engine(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "power=" + power +
                '}';
    }
}
