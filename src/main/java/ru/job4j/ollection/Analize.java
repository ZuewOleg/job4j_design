package ru.job4j.ollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, String> currents = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (var p : previous) {
            if (currents.containsKey(p.getId())) {
                if (!currents.containsValue(p.getName())) {
                    rsl.changed++;
                }
            }
                if (previous.size() > currents.size()) {
                    rsl.deleted = previous.size() - currents.size();
                } else if (previous.size() < currents.size()) {
                    rsl.added = currents.size() - previous.size();
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
