package ru.job4j.ood.lsp;

public class Human {
    private String name;
    private int age;
    private String nameSpeciality;

    public Human(String name, int age, String nameSpeciality) {
        this.name = name;
        this.age = age;
        this.nameSpeciality = nameSpeciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }
}
