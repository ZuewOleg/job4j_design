package ru.job4j.serialization.json;

public class Auto {
    private String brand;

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
