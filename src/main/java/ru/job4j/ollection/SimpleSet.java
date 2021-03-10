package ru.job4j.ollection;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> set;

    public SimpleSet(int size) {
        this.set = new SimpleArray<>(size);
    }

    public boolean contains(T value) {
        boolean check = false;
        for (var s : set) {
            if (value.equals(s)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void add(T model) {
        if (!contains(model)) {
            set.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public String toString() {
        return "SimpleSet{"
                + "set=" + set
                + '}';
    }
}
