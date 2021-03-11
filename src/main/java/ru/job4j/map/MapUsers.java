package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapUsers {
    public static void main(String[] args) {
        User user1 = new User("user1", 1,
                new GregorianCalendar(2001, 01, 1));
        User user2 = new User("user1", 1,
                new GregorianCalendar(2001, 01, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println("map" + map);
    }

}
