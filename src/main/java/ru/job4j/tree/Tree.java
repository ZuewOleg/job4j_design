package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    /** Должен находить узел по значению parent и добавлять в него дочерний узел со значением child
     * В этом методе нужно проверить, что значения child еще нет в дереве а parent есть.
     * Если child есть, то метод должен вернуть false.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parents = findBy(parent);
        Optional<Node<E>> childes = findBy(child);
        if (parents.isPresent()) {
            if (childes.isEmpty()) {
                Node<E> nextChild = new Node<>(child);
                parents.get().getChildren().add(nextChild);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }


}
