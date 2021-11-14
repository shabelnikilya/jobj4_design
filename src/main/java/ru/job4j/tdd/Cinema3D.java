package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public boolean checkFreePlace(Session session, int row, int column, Calendar calendar) {
        return true;
    }

    @Override
    public void add(Session session) {
    }

    @Override
    public int countSessions() {
        return 1;
    }
}
