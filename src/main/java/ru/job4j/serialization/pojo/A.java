package ru.job4j.serialization.pojo;

import org.json.JSONPropertyIgnore;

public class A {
    private B b;

    @JSONPropertyIgnore /* Чтобы избежать исключения необходимо разорвать цепочку,
    как правило это делается в момент перехода по ссылке на объект, который уже сериализован */
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getHello() {
        return "Hello";
    }
}