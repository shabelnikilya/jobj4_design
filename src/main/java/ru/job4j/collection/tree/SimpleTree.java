package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> find = findBy(parent);
        if (find.isPresent() && findBy(child).isEmpty()) {
            return find.get().children.add(new Node(child));
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }

    @Override
    public boolean isBinary() {
        return findByPredicate(x -> x.children.size() > 2).isEmpty();
    }

    public Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
