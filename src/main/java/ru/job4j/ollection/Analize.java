package ru.job4j.ollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, User> currents = current.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        for (var p : previous) {
            User remove = currents.remove(p.getId());
            if (remove == null) {
                rsl.deleted++;
            } else if (!remove.equals(p)) {
                rsl.changed++;
            }
        }
        rsl.added = current.size() - (previous.size() - rsl.deleted);
        return rsl;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
