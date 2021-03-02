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

    public T[] getArray() {
        return array;
    }

    public void add(T model) {
            this.array[index] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return this.array[index];
    }

    public boolean remove(int index) {
        if (Objects.checkIndex(index, this.index) != -1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            return true;
        }
        return false;
    }

    public boolean set(int index, T model) {
        if (Objects.checkIndex(index, this.index) != -1) {
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
