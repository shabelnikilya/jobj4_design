package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    Node<E> first;
    Node<E> last;
    int size;
    int modCount;

    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node(last, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = first;
        for (int i = 0; i < index; i++) {
            rsl.item = rsl.next.item;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> nextNode = first;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E rsl = nextNode.item;
                nextNode = nextNode.next;
                return rsl;
            }
        };
    }

    public static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
