package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
        BufferedReader in = new BufferedReader(reader)) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] l = line.split(" ");
                if (l[l.length - 2].equals("404")) {
                    rsl.add(line + System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
