package ru.job4j.ollection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    transient T[] array;
    private int size;
    private int index;
    int modCount = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public T get(int index) {
        return this.array[index];
    }

    public void add(T model) {
        if (this.array[index] == null) {
            this.array[index] = model;
        } else if (index == array.length) {
            Arrays.copyOf(array, size + index);
            array[index] = model;
            size = index + 1;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() throws ConcurrentModificationException, NoSuchElementException {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(index++);
            }
        };
    }
}
