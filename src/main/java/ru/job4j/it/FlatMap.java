package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();

    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (cursor.hasNext()) {
            return true;
        } else if (data.hasNext()) {
            cursor = data.next();
            return cursor.hasNext() || hasNext();
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    return cursor.next();
    }
}
