package ru.job4j.it;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(List.of(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(List.of(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(List.of(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(List.of(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterLastWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2));
        ListUtils.addAfter(input, 4, 3);
    }

    @Test
    public void whenRemoveIfTruePredicate() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 11, 7, 6));
        ListUtils.removeIf(input, x -> x % 2 != 0);
        assertThat(input, is(List.of(0, 2, 6)));
    }

    @Test
    public void whenRemoveIfTruePredicateEmptyInput() {
        List<Integer> input = new ArrayList<>();
        ListUtils.removeIf(input, x -> x % 2 != 0);
        assertThat(input, is(List.of()));
    }

    @Test
    public void whenReplaceIfTruePredicate() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 11, 7, 6));
        ListUtils.replaceIf(input, x -> x % 2 != 0, -1);
        assertThat(input, is(List.of(0, -1, 2, -1, -1, 6)));
    }

    @Test
    public void whenReplaceIfTruePredicateEmptyInput() {
        List<Integer> input = new ArrayList<>();
        ListUtils.replaceIf(input, x -> x % 2 != 0, -1);
        assertThat(input, is(List.of()));
    }

    @Test
    public void whenRemoveAllCollection() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 11, 7, 6));
        List<Integer> remove = List.of(1, 7, 22, 63);
        ListUtils.removeAll(input, remove);
        assertThat(input, is(List.of(0, 2, 11, 6)));
    }

    @Test
    public void whenRemovaAllCollectionEmpryRemoveCollection() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 11, 7, 6));
        List<Integer> remove = List.of();
        ListUtils.removeAll(input, remove);
        assertThat(input, is(List.of(0, 1, 2, 11, 7, 6)));
    }
}