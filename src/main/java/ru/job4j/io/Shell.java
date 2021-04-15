package ru.job4j.io;

import java.util.Stack;

public class Shell {
    Stack<String> way = new Stack<>();

    public void cd(String path) {
        way.add(path);
    }

    public String pwd() {
        String current;
        String rsl = "";
        for (int i = 0; i < way.size(); i++) {
            if (way.get(i).startsWith("/")) {
                rsl = way.get(i);
            } else if (way.get(i).startsWith("..") || way.get(i + 1).startsWith("..")) {
                current = way.pop();
                if (current.length() > 2) {
                    String[] folder = current.split("/");
                    rsl = "/" + folder[1];
                } else {
                    rsl = "/";
                }
            } else if (!way.get(i).startsWith("/") || !way.get(i).startsWith("..")) {
                current = "/" + way.get(i) + "/" + way.pop();
                rsl = current;
            }
        }
        return rsl;
    }
}
