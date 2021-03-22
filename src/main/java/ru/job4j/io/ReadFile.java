package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    /* public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } */

        public static void main(String[] args) {
            try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
                in.lines().forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
