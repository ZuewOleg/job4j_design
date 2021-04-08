package ru.job4j.serialization.jaxb;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "auto")
public class Auto {

    @XmlAttribute
    private String brand;

    public Auto() {
    }

    public Auto(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Auto{"
                + "brand='" + brand + '\''
                + '}';
    }
}
