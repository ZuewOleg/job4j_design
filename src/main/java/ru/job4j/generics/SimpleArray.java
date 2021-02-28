package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public T[] getArray() {
        return array;
    }

    public void add(T model) {
        if (this.array[index] == null) {
            this.array[index] = model;
        }
    }

    public T get(int index) {
        return this.array[index];
    }

    public boolean remove(int index) {
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(array, index + 1, array, index, size - index);
            array[size - 1] = null;
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
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}
