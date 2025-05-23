package com.umuthokelek.library;

import java.util.Objects;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User u = (User) o;
        return name.equals(u.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
