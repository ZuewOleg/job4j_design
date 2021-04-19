package ru.job4j.io.control;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search extends SimpleFileVisitor<Path> {
    private final List<Path> paths;
    private final Predicate<String> condition;

    public Search(Predicate<String> condition) {
        paths = new ArrayList<>();
        this.condition = condition;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (condition.test(file.getFileName().toString())) {
            paths.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
