package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.List;

public class PersonController implements PersonDatabase {

    List<Person> list = new ArrayList<>();

    @Override
    public void add(Person person) {
        synchronized (this) {
            list.add(person);
        }

    }

    @Override
    public void delete(int id) {
        synchronized (this) {
            list = list.stream().filter(p -> p.id() != id).toList();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (this) {
            return list.stream().filter(p -> p.name() == name).toList();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (this) {
            return list.stream().filter(p -> p.address() == address).toList();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (this) {
            return list.stream().filter(p -> p.phoneNumber() == phone).toList();
        }
    }
}
