package ru.job4j.ollection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int index;
    private int modCount = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void checkSize() {
        if (index == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return this.array[index];
    }

    public void add(T model) {
        checkSize();
        array[index++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < index;
            }

            @Override
            public T next() throws ConcurrentModificationException, NoSuchElementException {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[count++];
            }
        };
    }
}
