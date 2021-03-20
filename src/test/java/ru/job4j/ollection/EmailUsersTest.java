package ru.job4j.ollection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EmailUsersTest {

    @Test
    public void mergeUser1AndUser3() {
        EmailUsers email = new EmailUsers();
        EmailUsers.User user1 = new EmailUsers.User("user1",
                new HashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        EmailUsers.User user2 = new EmailUsers.User("user2",
                new HashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net")));
        EmailUsers.User user3 = new EmailUsers.User("user3",
                new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        EmailUsers.User user4 = new EmailUsers.User("user4",
                new HashSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru")));
        EmailUsers.User user5 = new EmailUsers.User("user5",
                new HashSet<>(Arrays.asList("xyz@pisem.net")));
        EmailUsers.User user6 = new EmailUsers.User("user1",
                new HashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru")));
        EmailUsers.User user7 = new EmailUsers.User("user3",
                new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")));
        List<EmailUsers.User> users = List.of(user1, user2, user3, user4, user5);
        Set<EmailUsers.User> rsl = Set.of(user6, user7);
        assertThat(rsl, is(email.merge(users)));
    }
}