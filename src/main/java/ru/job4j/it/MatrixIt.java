package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
       boolean lengthColumnLess  = column < data.length;
       if (lengthColumnLess && row < data[column].length) {
           return true;
       } else if (lengthColumnLess) {
           column++;
           row = 0;
           return hasNext();
       }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[column][row++];
    }
}
