package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while (read.ready()) {
                String line = read.readLine();
                if (line.contains("=")) {
                    String[] l = line.split("=");
                    values.put(l[0], l[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String rsl = "";
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            while (read.ready()) {
                String line = read.readLine();
                if (line.contains("=")) {
                    String[] l = line.split("=");
                    if (key.equals(l[0])) {
                        rsl = l[1];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
