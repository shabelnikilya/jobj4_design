package ru.job4j.generics;

import java.util.Objects;

public class Worker extends User {
    private String id;

    public Worker(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Worker{" + "id='" + id
                + '\'' + '}';
    }
}
