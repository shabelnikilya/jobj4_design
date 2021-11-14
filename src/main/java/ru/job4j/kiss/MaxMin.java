package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    static <T> T findMaxOrMin(List<T> value, Comparator<T> comparator, Predicate<Integer> pred) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (pred.test(comparator.compare(rsl, value.get(i)))) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator, x -> x < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator, x -> x > 0);
    }
}
