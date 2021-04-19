package ru.job4j.io.control;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pass {
    private static Predicate<String> searchType(String type, String fileName) {
        Predicate<String> predicate = null;
        if (type.equals("mask")) {
            String name = fileName.replace("*", "");
            predicate = t -> t.contains(name);
        }
        if (type.equals("name")) {
            predicate = t -> t.equals(fileName);
        }
        if (type.equals("regex")) {
            String name = fileName.replace("\"", "");
            Pattern pattern = Pattern.compile(name);
            Matcher matcher = pattern.matcher("");
            predicate = t -> matcher.reset(t).matches();
        }
        return predicate;
    }

    private static List<Path> find(String path, Predicate<String> predicate) throws IOException {
        Search search = new Search(predicate);
        Path start = Paths.get(path);
        Files.walkFileTree(start, search);
        return search.getPaths();
    }

    private static void write(List<Path> paths, String output) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(output)))) {
            for (Path path : paths) {
                out.println(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Data data = new Data(args);
        if (data.valid()) {
            Predicate<String> predicate = searchType(data.type(), data.fileName());
            List<Path> result = find(data.directory(), predicate);
            write(result, data.output());
        }
    }
}
