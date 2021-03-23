package ru.job4j.io;

import java.io.*;
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
                    rsl.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(file)))) {
            for (int i = 0; i < log.size(); i++) {
                out.write(log.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
