package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            PrintWriter writer = new PrintWriter(new FileOutputStream(target));
            String serverDrop = null;
            while (read.ready()) {
                String status = read.readLine();
                if (serverDrop == null && (status.startsWith("400") || status.startsWith("500"))) {
                    String drop = status.split(" ")[1] + " server drop";
                    rsl.add(drop);
                    writer.println(rsl);
                    serverDrop = status;
                } else if (serverDrop != null && (!status.startsWith("400") || !status.startsWith("500"))) {
                    String up = status.split(" ")[1] + " server up";
                    rsl.add(up);
                    writer.println(rsl);
                    serverDrop = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/server.log", "./data/target.log");
    }
}