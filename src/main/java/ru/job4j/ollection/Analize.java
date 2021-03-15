package ru.job4j.ollection;

import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info(0, 0, 0);
        for (var p : previous) {
            for (var c : current) {
                    if (p.getId() == c.getId()) {
                if (!p.getName().equals(c.getName())) {
                    rsl.changed++;
                }
                }
                if (previous.size() > current.size()) {
                    rsl.deleted = previous.size() - current.size();
                } else if (previous.size() < current.size()) {
                    rsl.added = current.size() - previous.size();
                }
            }
        }
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
