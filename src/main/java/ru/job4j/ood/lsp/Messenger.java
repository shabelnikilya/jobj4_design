package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Messenger {

    private List<Account> accountList;
    private final Calendar sinceDate = new GregorianCalendar(2021, Calendar.FEBRUARY, 20);

    public void createAccount(Account account) {
        accountList.add(account);
    }

    public void deleteAccount(int index) {
        accountList.remove(index);
    }

    public void sendMessage(Account account, String text) {
            if (account.getDateCreate().before(sinceDate)) {
                System.out.println("сообщение отправлено");
        }
    }
}
