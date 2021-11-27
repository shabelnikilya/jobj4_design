package ru.job4j.ood.dip;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String profession;

    public User(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(profession, user.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, profession);
    }
}
