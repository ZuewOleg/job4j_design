package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        for (var s : args) {
            int index = s.indexOf('='); /* находим индекс ключа (indexOf возвращает индекс в этой строке
            первого вхождения указанного символа) */
            if (index == -1 || index == 0 || index == s.length() - 1) { /* проверяем знчание индекса ключа */
                throw new IllegalArgumentException();
            }
            values.put(s.substring(1, index), s.substring(index + 1)); /* запись в мапу (index + 1 -> после "=") */
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("encoding"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
