package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while (read.ready()) {
                String status = read.readLine();
                if (status.startsWith("400") || status.startsWith("500")) {
                    String drop = "Конец работы сервера - " + status.split(" ")[1] + System.lineSeparator();
                    rsl.add(drop);
                } else {
                    String up = "Начало работы сервера - " + status.split(" ")[1] + System.lineSeparator();
                    rsl.add(up);
                }
                PrintWriter writer = new PrintWriter(new FileOutputStream(target));
                for (var r : rsl) {
                    writer.write(r);
                }
            }
            System.out.println(rsl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/target.log");
    }
}