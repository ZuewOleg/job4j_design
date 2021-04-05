package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final List<String> botAnswerList;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        botAnswerList = new ArrayList<>();
    }

    public void run() {
        String in = "";
        boolean stop = false;
        List<String> list = new ArrayList<>();
        while (!in.equals(OUT)) {
            Scanner input = new Scanner(System.in);
            in = input.nextLine();
            list.add(in);
            if (in.equals(STOP)) {
                stop = true;
            } else if (in.equals(CONTINUE)) {
                stop = false;
            }
            if (!stop && !in.equals(OUT)) {
                String answer = answer();
                System.out.println(answer);
                list.add(answer);
            }
        }
        logSave(list);
    }

    private void logSave(List<String> list) {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(path)))) {
            for (String str : list) {
                writer.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String answer() {
        if (botAnswerList.size() == 0) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
                while ((line = reader.readLine()) != null) {
                    botAnswerList.add(line);
                }
                if (botAnswerList.size() <= 1) {
                    throw new IndexOutOfBoundsException(
                            "Bot can't answer due to lack of vocabulary");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return botAnswerList.get((int) (Math.random() * botAnswerList.size()));
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chat.txt", "botAnswers.txt");
        cc.run();
    }
}
