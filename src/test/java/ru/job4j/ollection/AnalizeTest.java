package ru.job4j.ollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void diffNoEditorialBoard() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        Analize.User user4 = new Analize.User(4, "four");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        previous.add(user4);
        List<Analize.User> current = new ArrayList<>();
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        Analize.Info rsl = new Analize.Info(0, 0, 0);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getAdded(), is(expect.getAdded()));
        assertThat(rsl.getChanged(), is(expect.getChanged()));
        assertThat(rsl.getDeleted(), is(expect.getDeleted()));
    }

    @Test
    public void diffAdded() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        Analize.User user4 = new Analize.User(4, "four");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        List<Analize.User> current = new ArrayList<>();
        current.add(user1);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        Analize.Info rsl = new Analize.Info(1, 0, 0);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getAdded(), is(expect.getAdded()));
    }

    @Test
    public void diffDeleted() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        Analize.User user4 = new Analize.User(4, "four");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        previous.add(user4);
        List<Analize.User> current = new ArrayList<>();
        current.add(user1);
        current.add(user2);
        current.add(user3);
        Analize.Info rsl = new Analize.Info(0, 0, 1);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getDeleted(), is(expect.getDeleted()));
    }

    @Test
    public void diffChanged() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(1, "third");
        Analize.User user4 = new Analize.User(2, "four");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        List<Analize.User> current = new ArrayList<>();
        current.add(user3);
        current.add(user4);
        Analize.Info rsl = new Analize.Info(0, 2, 0);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getChanged(), is(expect.getChanged()));
    }

    @Test
    public void diffAddedAndChanged() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        Analize.User user4 = new Analize.User(4, "four");
        Analize.User user6 = new Analize.User(1, "six");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        List<Analize.User> current = new ArrayList<>();
        current.add(user6);
        current.add(user2);
        current.add(user3);
        current.add(user4);
        Analize.Info rsl = new Analize.Info(1, 1, 0);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getAdded(), is(expect.getAdded()));
        assertThat(rsl.getChanged(), is(expect.getChanged()));
    }

    @Test
    public void diffDeletedAndChanged() {
        Analize.User user1 = new Analize.User(1, "first");
        Analize.User user2 = new Analize.User(2, "second");
        Analize.User user3 = new Analize.User(3, "third");
        Analize.User user6 = new Analize.User(1, "six");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(user1);
        previous.add(user2);
        previous.add(user3);
        List<Analize.User> current = new ArrayList<>();
        current.add(user6);
        current.add(user2);
        Analize.Info rsl = new Analize.Info(0, 1, 1);
        Analize.Info expect = new Analize().diff(previous, current);
        assertThat(rsl.getChanged(), is(expect.getChanged()));
        assertThat(rsl.getDeleted(), is(expect.getDeleted()));
    }
}