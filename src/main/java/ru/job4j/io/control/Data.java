package ru.job4j.io.control;

import java.util.Objects;

public class Data {
    private final String[] args;

    public Data(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 4
                || Objects.equals(directory(), null) || Objects.equals(fileName(), null)
                || Objects.equals(type(), null) || Objects.equals(output(), null)) {
            throw new IllegalArgumentException("Root folder is null. "
                    + "Usage java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt");
        }
        return true;
    }

    public String directory() {
        return args[1].substring(3);
    }

    public String fileName() {
        return args[1].substring(3);
    }

    public String type() {
        return args[2].substring(3);
    }

    public String output() {
        return args[3].substring(3);
    }
}
