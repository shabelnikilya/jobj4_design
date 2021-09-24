package ru.job4j.collection.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNonNullString() {
        String inFirst = "check";
        String inSecond = new String("check");
        Set<String> set = new SimpleSet<>();
        assertTrue(set.add(inFirst));
        assertTrue(set.contains(inSecond));
        assertFalse(set.add(inSecond));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElementException() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> i = set.iterator();
        i.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorConcurrentModificationException() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        Iterator<Integer> i = set.iterator();
        assertThat(i.next(), is(1));
        set.add(5);
        assertThat(i.next(), is(2));
    }
}