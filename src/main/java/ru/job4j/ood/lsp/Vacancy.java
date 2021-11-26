package ru.job4j.ood.lsp;

public class Vacancy {
    private String nameCompany;
    private String name;
    private int count;
    private boolean free;

    public Vacancy(String nameCompany, String name, int count, boolean free) {
        this.nameCompany = nameCompany;
        this.name = name;
        this.count = count;
        this.free = free;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
