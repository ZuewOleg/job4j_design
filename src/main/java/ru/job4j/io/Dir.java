package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) { /* Проверяет, существует ли файл или каталог, обозначенный этим абстрактным именем пути */
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) { /* Проверяет, является ли файл, обозначенный этим абстрактным именем пути, каталогом */
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("%s", file.getAbsoluteFile()));
        System.out.println(String.format("size : %s", file.getTotalSpace())); /* Возвращает размер раздела, названного этим абстрактным именем пути */
        for (File subfile : file.listFiles()) { /* Возвращает массив абстрактных путей, обозначающих файлы в каталоге, обозначенном этим абстрактным путем */
            System.out.println(String.format("name: %s", subfile.getName())); /* Возвращает абсолютную форму этого абстрактного пути */
            System.out.println(String.format("size : %s", subfile.length()));
        }
    }
}
