package ru.job4j.design.lsp;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void sortFoodOnStorage() {
        List<Storage> storages = List.of(new Shop(), new Trash(), new Warehouse());
        Food apple = new Apple(
                "apple",
                new GregorianCalendar(2022, Calendar.JANUARY, 5),
                new GregorianCalendar(2022, Calendar.JANUARY, 10),
                180, 10
        );
        ControllQuality sort = new ControllQuality(storages);
        assertTrue(sort.sortFoodOnStorage(apple));
    }

    @Test
    public void sortFoodOnStorageInShopWithDiscount() {
        Shop s = new Shop();
        Trash t = new Trash();
        Warehouse w = new Warehouse();
        List<Storage> storages = List.of(s, t, w);
        Calendar expiry = Calendar.getInstance();
        Calendar create = Calendar.getInstance();
        expiry.add(Calendar.DAY_OF_MONTH, 1);
        create.add(Calendar.DAY_OF_MONTH, -9);
        Apple apple = new Apple(
                "apple",
                expiry,
                create,
                180, 10
        );
        ControllQuality sort = new ControllQuality(storages);
        sort.sortFoodOnStorage(apple);
        assertThat(apple.getPrice(), is(162));
    }

    @Test
    public void sortFoodOnStorageInTrash() {
        Shop s = new Shop();
        Trash t = new Trash();
        Warehouse w = new Warehouse();
        List<Storage> storages = List.of(s, t, w);
        Apple apple = new Apple(
                "apple",
                new GregorianCalendar(2022, Calendar.JANUARY, 6),
                new GregorianCalendar(2022, Calendar.JANUARY, 1),
                180, 10
        );
        ControllQuality sort = new ControllQuality(storages);
        assertTrue(sort.sortFoodOnStorage(apple));
    }

    @Test
    public void sortFoodOnStorageInWarehouse() {
        Shop s = new Shop();
        Trash t = new Trash();
        Warehouse w = new Warehouse();
        List<Storage> storages = List.of(s, t, w);
        Calendar expiry = Calendar.getInstance();
        Calendar create = Calendar.getInstance();
        expiry.add(Calendar.DAY_OF_MONTH, 10);
        create.add(Calendar.DAY_OF_MONTH, -1);
        Apple apple = new Apple(
                "apple",
                expiry,
                create,
                180, 10
        );
        ControllQuality sort = new ControllQuality(storages);
        assertTrue(sort.sortFoodOnStorage(apple));
    }
}