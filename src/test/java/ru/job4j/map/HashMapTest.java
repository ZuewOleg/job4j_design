package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HashMapTest {
    private HashMap map = new HashMap<String, User>();
    private HashMap.User one = new HashMap.User(1, "John");
    private HashMap.User two = new HashMap.User(2, "Nick");
    private HashMap.User three = new HashMap.User(3, "Jack");

    @Before
    public void added() {
        map.insert("first", one);
        map.insert("second", two);
        map.insert("third", three);
    }

    @Test
    public void get() {
        assertThat(map.get("first"), is(one));
    }

    @Test
    public void insert() {
        assertThat(map.getSize(), is(3));
    }

    @Test
    public void delete() {
        map.delete("third");
        assertThat(map.getSize(), is(2));
    }
}