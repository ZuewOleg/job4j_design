package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public static void unavailable(String source, String target) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String serverDrop = null;
            while (read.ready()) {
                String status = read.readLine();
                if (serverDrop == null && (status.startsWith("400") || status.startsWith("500"))) {
                    String drop = "Конец работы сервера - " + status.split(" ")[1] + System.lineSeparator();
                    rsl.add(drop);
                    serverDrop = status;
                } else if (serverDrop != null && (!status.startsWith("400") && !status.startsWith("500"))) {
                    String up = "Начало работы сервера - " + status.split(" ")[1] + System.lineSeparator();
                    rsl.add(up);
                    serverDrop = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var r : rsl) {
                writer.write(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.txt", "./data/analysis_server.txt");
    }
}