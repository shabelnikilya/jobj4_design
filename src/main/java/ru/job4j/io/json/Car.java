package ru.job4j.io.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean sportCar;
    @XmlAttribute
    private int speedCar;
    @XmlAttribute
    private String model;
    @XmlElement(name="engine")
    private Engine engine;
    @XmlElementWrapper(name = "colors")
    private String[] colors;

    public Car() {
    }

    public Car(boolean sportCar, int speedCar, String model, Engine engine, String... colors) {
        this.sportCar = sportCar;
        this.speedCar = speedCar;
        this.model = model;
        this.engine = engine;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "sportCar=" + sportCar +
                ", speedCar=" + speedCar +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", colors=" + Arrays.toString(colors) +
                '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Car car = new Car(false, 140, "BMW X2"
                , new Engine(177), "Yellow", "Black");
        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            String xmL = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            xmL = writer.getBuffer().toString();
            System.out.println(xmL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xmL)) {
            Car rsl = (Car) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }
    }
}
