package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIterator(final int[] numbers) {
        int[] rsl = new int[numbers.length];
        int i = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                rsl[i++] = num;
            }
        }
        this.numbers = Arrays.copyOf(rsl, i);
    }

    @Override
    public boolean hasNext() {
        return point < numbers.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }
}
