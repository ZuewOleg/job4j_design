package ru.job4j.serialization.jaxb;

import ru.job4j.serialization.json.Auto;

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
    private boolean insured;

    @XmlAttribute
    private int age;
    private Auto auto;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Car() { }

    public Car(boolean insured, int age, Auto auto, String... statuses) {
        this.insured = insured;
        this.age = age;
        this.auto = auto;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Car{"
                + "insured=" + insured
                + ", age=" + age
                + ", auto=" + auto
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        Car car = new Car(true, 6, new Auto("BMW, 325"),
                "No deformations", "2 owners by PTS");

        JAXBContext context = JAXBContext.newInstance(Car.class); /* Получаем контекст для доступа к АПИ */
        Marshaller marshaller = context.createMarshaller(); /* Создаем сериализатор */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); /* Указываем, что нам нужно форматирование */

        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer); /* Сериализуем */
            xml = writer.getBuffer().toString();
            System.out.println(xml);

            Unmarshaller unmarshaller = context.createUnmarshaller(); /* Для десериализации нам нужно создать десериализатор */
            try (StringReader reader = new StringReader(xml)) {
                Car result = (Car) unmarshaller.unmarshal(reader); /* десериализуем */
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
