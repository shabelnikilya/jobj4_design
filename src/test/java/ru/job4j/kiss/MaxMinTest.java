package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class MaxMinTest {
    List<Integer> list;
    MaxMin maxMin;

    @Before
    public void initList() {
        list = List.of(1, 7, 3, 4);
        maxMin = new MaxMin();
    }

    @Test
    public void max() {
        assertThat(maxMin.max(list, Comparator.comparingInt(x -> x)), is(7));
    }

    @Test
    public void min() {
            assertThat(maxMin.min(list, Comparator.comparingInt(x -> x)), is(1));
    }
}