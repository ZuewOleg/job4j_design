package ru.job4j.ollection;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {
    /** вставляет до индекса */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /** вставляет после индекса */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.previousIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /** удаляет все элементы, которые удовлетворяют предикату */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T t = i.next();
            if (filter.test(t)) {
                i.remove();
            }
        }
    }

    /** заменяет все элементы, которые удовлетворяют предикату */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            T t = i.next();
            if (filter.test(t)) {
                i.set(value);
            }
        }
    }

    /** удаляет из списка те элементы, которые есть в elements */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> e = elements.listIterator();
        while (e.hasNext()) {
            T elm = e.next();
            ListUtils.removeIf(list, x -> x.equals(elm));
        }
    }
}
