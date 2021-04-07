package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean insured;
    private final int age;
    private final Auto auto;
    private final String[] statuses;

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

    public static void main(String[] args) {
        final Car car = new Car(true, 6, new Auto("BMW, 325"),
                "No deformations", "2 owners by PTS");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));

        /* Модифицируем json-строку */
        final String carJson =
                "{"
                        + "\"insured\":true,"
                        + "\"age\":8,"
                        + "\"auto\":"
                        + "{"
                        + "\"brand\":\"Lada, 2114\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Deformations\",\"1 owners by PTS\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);
    }
}
