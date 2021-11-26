package ru.job4j.ood.lsp;

public class GetJobInGoogle extends  GetJob {

    @Override
    public void addHumanInCompany(Company company, Human human) {
        if (company.getVacancy().getFree() && human.getAge() < 37) {
            System.out.println("устроен в компанию google");
        }
    }
}
