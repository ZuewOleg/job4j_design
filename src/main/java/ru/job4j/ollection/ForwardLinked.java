package ru.job4j.ollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) { /* если список пуст, то удолять нечего, кидаем исключение */
            throw new NoSuchElementException();
        }
        T value = head.value; /* получем значение удаляемого узла */
        head = head.next; /* удаление */
        return value; /* возвращаем значение */
    }

    public T deleteLast() {
        if (head == null) { /* если список пуст, то удолять нечего, кидаем исключение */
            throw new NoSuchElementException();
        }
        if (head.next == null) { /* в списке один элемент, следовательно удаляем голову */
            T value = head.value;
            head = null;
            return value;
        }
        /* иначе в списке больше одного элемента */
        Node<T> beforeLast = null; /* предпослений элемент в списке */
        Node<T> last = head; /* последний элемент в списке */
        /* доходим до конца списка */
        while (last.next != null) {
            beforeLast = last;
            last = last.next;
        }
        T value = last.value; /* получем значение удаляемого узла */
        beforeLast.next = null; /* удаляем последний элемент, и удалаляем удаление на него ссылки */
        /* Если ссылка на него, то уже не сможем получить доступ */
        return value; /* возвращаем значение */

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
