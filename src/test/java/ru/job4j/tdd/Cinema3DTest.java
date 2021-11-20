package ru.job4j.tdd;

import org.junit.Test;
import java.util.Calendar;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Cinema3DTest {

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        assertThat(cinema.countSessions(), is(1));
    }

    @Test
    public void checkFreePlace() {
        Session session = new Session3D();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        cinema.add(session);
        assertTrue(cinema.checkFreePlace(session, 1, 1, date));
    }

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyWhenIncorrectYearDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyWhenIncorrectPlaceCinema() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 55, 1, date);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyWhenThisPlaceOccupied() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 10, 10, 23, 00);
        Ticket ticketOne = cinema.buy(account, 3, 1, date);
        Ticket ticketSecond = cinema.buy(account, 3, 1, date);
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertNull(sessions);
    }
}