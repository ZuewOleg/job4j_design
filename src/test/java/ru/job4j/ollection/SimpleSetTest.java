package ru.job4j.ollection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetTest {
    @Test
    public void add() {
        SimpleSet<Integer> set = new SimpleSet<>(3);
        set.add(1);
        set.add(2);
        set.add(1);
        SimpleSet<Integer> expect = new SimpleSet<>(3);
        expect.add(1);
        expect.add(2);
        assertThat(set.iterator().next(), is(expect.iterator().next()));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenTestsIterator() {
        SimpleSet<Integer> set = new SimpleSet<>(5);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(3));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void thenModifyArray() {
        SimpleSet<Integer> set = new SimpleSet<>(5);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(3));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        set.add(4);
        iterator.next();
    }
}