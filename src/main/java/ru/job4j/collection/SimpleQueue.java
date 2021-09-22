package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int inSize;
    private int outSize;

    public T poll() {
        if (outSize == 0) {
            while (outSize != inSize) {
                out.push(in.pop());
                outSize++;
            }
            inSize = 0;
            outSize--;
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        inSize++;
    }
}
