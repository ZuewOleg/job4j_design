package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            int rsl = i * 1;
            try (FileOutputStream out = new FileOutputStream("Multiple.txt")) {
                out.write(("1 * 1 = " + rsl).getBytes());
                out.write(("1 * 2 = " + rsl).getBytes());
                out.write(("1 * 3 = " + rsl).getBytes());
                out.write(("1 * 4 = " + rsl).getBytes());
                out.write(("1 * 5 = " + rsl).getBytes());
                out.write(("1 * 6 = " + rsl).getBytes());
                out.write(("1 * 7 = " + rsl).getBytes());
                out.write(("1 * 8 = " + rsl).getBytes());
                out.write(("1 * 9 = " + rsl).getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
