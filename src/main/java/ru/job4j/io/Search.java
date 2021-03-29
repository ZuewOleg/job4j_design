package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[args.length - 1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static class SearchFiles extends SimpleFileVisitor<Path> {
        final Predicate<Path> predicate;
        List<Path> paths;

        public SearchFiles(Predicate<Path> predicate) {
            this.predicate = predicate;
            this.paths = new ArrayList<>();
        }

        public List<Path> getPaths() {
            return paths;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (predicate.test(file.toAbsolutePath().getFileName())) {
                paths.add(file.toAbsolutePath());
            }
            return super.visitFile(file, attrs);
        }
    }
}
