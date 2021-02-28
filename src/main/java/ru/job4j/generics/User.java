package ru.job4j.generics;

import java.util.Objects;

public class User extends Base {
    private final String id = super.getId();

    public User(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{"
                + "id='" + id + '\''
                + '}';
    }
}
