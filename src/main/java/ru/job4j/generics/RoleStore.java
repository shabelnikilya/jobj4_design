package ru.job4j.generics;

public class RoleStore implements Store<Worker>{
    private final Store<Worker> role = new MemStore<>();

    @Override
    public void add(Worker model) {
        role.add(model);
    }

    @Override
    public boolean replace(String id, Worker model) {
        return role.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return role.delete(id);
    }

    @Override
    public Worker findById(String id) {
        return role.findById(id);
    }
}
