package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size = 10;
    private int index = 0;

    public SimpleArray(T[] array) {
        this.array = array;
    }

    public void add(T model) {
        if (array[index] == null) {
            array[index] = model;
        }
        index++;
    }

    public T get(int index) {
        T rsl = array[index];
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                rsl = array[i];
            }
        }
        return rsl;
    }

    public boolean remove(int index) {
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(array, index + 1, array, index, size - index);
            array[size - 1] = null;
            size--;
        }
        return rsl;
    }

    public boolean set(int index, T model) {
        boolean rsl = index != -1;
        if (rsl) {
            array[index] = model;
        }
        return rsl;
    }
    @Override
    public Iterator<T> iterator() {
        class SimpleArrayIterator implements Iterator<T> {
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        }
        return new SimpleArrayIterator();
    }
}
