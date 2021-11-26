package ru.job4j.ood.lsp;

import java.util.Calendar;
import java.util.Date;

public class Account {
    private String name;
    private String email;
    private Calendar dateCreate;

    public Account(String name, String email, Calendar dateCreate) {
        this.name = name;
        this.email = email;
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Calendar dateCreate) {
        this.dateCreate = dateCreate;
    }
}


