package ru.job4j.serialization.pojo;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.serialization.json.Auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isInsured() {
        return insured;
    }

    public int getAge() {
        return age;
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
        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"brand\":\"Audi, A4\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("No deformations");
        list.add("3 owners by PTS");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Car car = new Car(true, 4, new Auto("Audi, A4"), "No deformations", "3 owners by PTS");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("insured", car.isInsured());
        jsonObject.put("age", car.getAge());
        jsonObject.put("auto", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}
