package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("Multiple.txt")
                ))) {
            out.println("1 * 1 = 1");
            out.println("1 * 2 = 2");
            out.println("1 * 3 = 3");
            out.println("1 * 4 = 4");
            out.println("1 * 5 = 5");
            out.println("1 * 6 = 6");
            out.println("1 * 7 = 7");
            out.println("1 * 8 = 8");
            out.println("1 * 9 = 9");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(("1 * 1 = 1" + System.lineSeparator()).getBytes());
            out.write(("1 * 2 = 2" + System.lineSeparator()).getBytes());
            out.write(("1 * 3 = 3" + System.lineSeparator()).getBytes());
            out.write(("1 * 4 = 4" + System.lineSeparator()).getBytes());
            out.write(("1 * 5 = 5" + System.lineSeparator()).getBytes());
            out.write(("1 * 6 = 6" + System.lineSeparator()).getBytes());
            out.write(("1 * 7 = 7" + System.lineSeparator()).getBytes());
            out.write(("1 * 8 = 8" + System.lineSeparator()).getBytes());
            out.write(("1 * 9 = 9" + System.lineSeparator()).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } */
    }
}
