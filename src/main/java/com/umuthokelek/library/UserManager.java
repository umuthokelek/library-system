package com.umuthokelek.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println(u.getName() + " successfully registered to the library.");
    }

    public Optional<User> findByName(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findFirst();
    }
}
