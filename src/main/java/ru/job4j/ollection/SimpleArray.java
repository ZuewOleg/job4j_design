package ru.job4j.ollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size;
    private int index;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public T get(int index) {
        return this.array[index];
    }

    public void add(T model, T[] array, int s) {
        if (s == array.length) {
            array = Arrays.copyOf(array, size + s);
            array[s] = model;
            size = s + 1;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
