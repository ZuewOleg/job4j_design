package ru.job4j.ollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedRevert<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null, null);
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

    public void revert() {
        Node<T> next; /* следующий узел */
        Node<T> prev = null; /* предыдущий узел */
        while (head != null) { /* если список не пустой */
            next = head.next; /* следующему узлу присваиваем ссылку на следующий узел */
            head.next = prev; /* ссылку на следующий узел меняем на предыдущий узел */
            prev = head; /* предыдущий узел меняем на head */
            head = next; /* head ссылается на следующий узел */
        }
        head = prev;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
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
