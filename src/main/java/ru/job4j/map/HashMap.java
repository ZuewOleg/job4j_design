package ru.job4j.map;

import java.util.*;

public class HashMap<K, V> {
    private Node<K, V>[] table; /* узел с парой */
    private int generation; /* сколько раз происходило увеличение */
    private int threshold;
    private int modCount;
    private int size;

    public HashMap() {
        table = new Node[16]; /* размер таблицы по умолчанию */
        threshold = (int) (table.length * 0.75f);
    }

    static class Node<K, V> { /* класс узла */
        final K key;
        V value;
        final int hash;

        public Node(K key, V value, int hash) {
            this.value = value;
            this.key = key;
            this.hash = hash;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }
    }

    private int hash(K key) { /* поиск хэша */
        if (key == null) {
                throw new NullPointerException();
        }
        int h = key.hashCode();
        return (h ^ (h >>> 16));
    }

    public boolean insert(K key, V value) { /* вставка */
        boolean rsl = true;
        int hash = hash(key);
        int index = hash % (table.length - 1);
        if (size >= threshold) {
            table = resize();
        } else if (table[index] == null) {
            table[index] = new Node<>(key, value, hash);
            size++;
            modCount++;
            rsl = true;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public V get(K key) {
        V rsl = null;
        int hash = hash(key);
        int index = hash % (table.length - 1);
        Node<K, V> node = table[index];
        if (node != null) {
            if (node.getKey().equals(key)) {
                rsl = node.getValue();
            }
        }
        return rsl;
    }

    public boolean delete(K key) {
        boolean rsl = true;
        int hash = hash(key);
        int index = hash % (table.length - 1);
        Node<K, V> node = table[index];
        if (node != null) {
        if (node.getKey().equals(key)) {
            table[index] = null;
            size--;
            modCount++;
            rsl = false;
        }
        }
        return rsl;
    }

    private Node<K, V>[] resize() {
        generation++;
        int index;
        Node<K, V>[] newTab = new Node[16 << generation];
        Node<K, V>[] oldTab = table;
        for (Node<K, V> old: oldTab) {
            index = old.hash % (newTab.length - 1);
            if (newTab[index] == null && old.key != null) {
                newTab[index] = old;
            }
        }
        return newTab;
    }

    public Iterator iterator() {
        return new Iterator<>() {
            int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public Node<K, V> next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = cursor; i < table.length; i++) {
                    if (table[i] != null) {
                        cursor = i;
                        break;
                    }
                }
                return table[cursor++];
            }
        };
    }
}
