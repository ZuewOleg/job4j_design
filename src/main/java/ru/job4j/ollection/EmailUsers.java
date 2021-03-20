package ru.job4j.ollection;

import java.util.*;

public class EmailUsers {
    public Set merge(List<User> users) {
        Map<String, User> emails = new HashMap<>();
        Map<User, User> dual = new HashMap<>();
        Set<User> rsl = new HashSet<>();
        for (var user : users) {
            boolean isMainUser = true;
            for (String email : user.getEmail()) {
                User prevUser = emails.putIfAbsent(email, user);
                if (prevUser != null) {  // Уже есть пользователь с таким e-mail, то достаем основного пользователя
                    prevUser = dual.getOrDefault(prevUser, prevUser);
                    prevUser.getEmail().addAll(user.getEmail()); // добавляем основному пользователю свои адреса
                    dual.put(user, prevUser);
                    isMainUser = false;
                }
            }
            if (isMainUser) { // если все адреса были уникальными
                rsl.add(user);
            }
        }
        return rsl;
    }

    public static class User {
        private String name;
        private Set<String> email;

        public User(String name, Set<String> email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public Set<String> getEmail() {
            return email;
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
            return Objects.equals(name, user.name)
                    && Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email);
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='"
                    + name + '\''
                    + ", email=" + email
                    + '}';
        }
    }
}
