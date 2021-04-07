package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Oleg Zuev";
        byte age = 28;
        char gender = 'M';
        double height = 176.3;
        float weight = 70.5f;
        int day = 17;
        short month = 9;
        long year = 1992L;
        boolean married = true;

        LOG.debug("User info name : {}, age : {}, gender: {}, height : {}, weight : {}, date of birth: {}.{}.{}, married: {}",
                name, age, gender, height, weight, day, month, year, married);
    }
}
