package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int size;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public void add(T model) {
            this.array[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return this.array[index];
    }

    public boolean remove(int index) {
        var rsl = Objects.checkIndex(index, this.index);
        if (rsl != -1 && rsl < array.length) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            this.index--;
            return true;
        }
        return false;
    }

    public boolean set(int index, T model) {
        var rsl = Objects.checkIndex(index, this.index);
        if (rsl != -1 && rsl < array.length) {
            array[index] = model;
            return true;
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int i;
            @Override
            public boolean hasNext() {
                return i < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(i++);
            }
        };
    }
}
