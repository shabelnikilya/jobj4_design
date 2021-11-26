package ru.job4j.ood.lsp;

public class Company {
    private String name;
    private Vacancy vacancy;

    public Company(String name, Vacancy vacancy) {
        this.name = name;
        this.vacancy = vacancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }


    public void add(Human human) {
        System.out.println("human - устроен на работу");
    }
}
