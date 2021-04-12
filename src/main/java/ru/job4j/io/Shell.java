package ru.job4j.io;

public class Shell {
    String way = "";

    public void cd(String path) {
        char colon = ':';
        boolean found = false;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == colon) {
                found = true;
            }
            if (path.startsWith(".") && (path.length() == 2)) {
                found = true;
                way = "/";
            }
            if (path.startsWith(".") && (path.length() > 2)) {
                found = true;
                String rsl = "";
                String[] root = path.split("/");
                for (int j = 0; j < root.length; j++) {
                    rsl = root[1];
                }
                way = "/" + rsl;
            }
        }
        if (!found) {
            way = path;
        }
    }

    public String pwd() {
        return way;
    }
}
