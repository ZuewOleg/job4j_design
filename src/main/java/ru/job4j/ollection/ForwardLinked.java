package ru.job4j.ollection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;


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

    public void addLast(T value) {
        Node<T> nodeLast = new Node<T>(value, null, last);
        if (last == null) {
            last = nodeLast;
            return;
        }
        Node<T> tail = last;
        while (tail.prev != null) {
            tail = tail.prev;
        }
        tail.prev = nodeLast;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T value = head.value;
        head = head.next;
        return value;
    }

    public T deleteLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        T value = last.value;
        last = last.prev;
        return value;
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

        public Node(T value, Node<T> next, Node<T> last) {
            this.value = value;
            this.next = next;
            this.prev = last;
        }
    }
}
