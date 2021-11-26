package ru.job4j.ood.lsp;

public class GetJob {

    public void listVacancy(Company company) {
        System.out.println("Перечесление штата");
    }

    public void addHumanInCompany(Company company, Human human) {
        if (company.getVacancy().getFree()) {
            company.add(human);
        }
    }
}
