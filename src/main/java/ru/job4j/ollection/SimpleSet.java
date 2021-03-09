package ru.job4j.ollection;

import java.util.*;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> set;

    public SimpleSet(int size) {
        this.set = new SimpleArray<>(size);
    }

    public T[] getSet() {
        return set.getArray();
    }

    public void add(T model) {
        boolean check = false;
            for (int i = 0; i < set.getSize(); i++) {
                if (model.equals(set.get(i))) {
                    check = true;
                    break;
                }
            }
        if (!check) {
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
