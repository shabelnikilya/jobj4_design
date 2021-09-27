package ru.job4j.collection.map;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {


    @Test
    public void whenPutThirdPair() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        assertTrue(run.put(19, "Roma"));
        assertTrue(run.put(22, "Igor"));
        assertTrue(run.put(36, "Jora"));
    }

    @Test
    public void whenPutManyPairWithCollision() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        run.put(88, "Kostya");
        assertFalse(run.put(54, "Elena"));
    }

    @Test
    public void whenGetKeyTwentyTwo() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        assertThat(run.get(22), is("Igor"));
    }

    @Test
    public void whenGetKeyNullValueRoma() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(null, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        assertThat(run.get(null), is("Roma"));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        assertNull(run.get(28));
    }

    @Test
    public void whenRemoveKeyTwentyTwo() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        assertTrue(run.remove(22));
    }

    @Test
    public void whenRemoveKeyFalse() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        assertFalse(run.remove(20));
    }

    @Test
    public void whenIteratorThreeKey() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        Iterator<Integer> it = run.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void whenIteratorNoSuchElement() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        Iterator<Integer> it = run.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorConcurrentModificationException() {
        SimpleMap<Integer, String> run = new SimpleMap<>();
        run.put(19, "Roma");
        run.put(22, "Igor");
        run.put(36, "Jora");
        Iterator<Integer> it = run.iterator();
        assertTrue(it.hasNext());
        it.next();
        run.put(98, "Aleksey");
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
    }
}