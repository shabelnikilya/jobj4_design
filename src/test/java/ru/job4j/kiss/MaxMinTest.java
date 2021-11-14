package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MaxMinTest {
    List<Integer> list;

    @Before
    public void initList() {
        list = List.of(1, 7, 3, 4);
    }

    @Test
    public void max() {
        MaxMin m = new MaxMin();
        assertThat(7, is(m.max(list, Comparator.comparingInt(x -> x))));
    }

    @Test
    public void min() {
            MaxMin m = new MaxMin();
            assertThat(1, is(m.min(list, Comparator.comparingInt(x -> x))));
    }
}