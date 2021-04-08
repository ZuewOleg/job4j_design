package ru.job4j.serialization.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private Contact contact;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Person() { }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");

        JAXBContext context = JAXBContext.newInstance(Person.class); /* Получаем контекст для доступа к АПИ */
        Marshaller marshaller = context.createMarshaller(); /* Создаем сериализатор */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); /* Указываем, что нам нужно форматирование */

        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer); /* Сериализуем */
            xml = writer.getBuffer().toString();
            System.out.println(xml);

            Unmarshaller unmarshaller = context.createUnmarshaller(); /* Для десериализации нам нужно создать десериализатор */
            try (StringReader reader = new StringReader(xml)) {
                Person result = (Person) unmarshaller.unmarshal(reader); /* десериализуем */
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
