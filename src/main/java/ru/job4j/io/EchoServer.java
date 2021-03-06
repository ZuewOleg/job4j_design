package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    @SuppressWarnings("checkstyle:InnerAssignment")
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) { /*  условие говорит о том, что сервер работает, пока его принудительно не закроют */
                Socket socket = server.accept(); /* ожидает, когда к нему обратиться клиент.
                Программа переходит в режим ожидания */
                try (OutputStream out = socket.getOutputStream(); /* Когда клиент обратился к серверу программа получает
                входной поток и может отправить данные в выходной поток */
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "";
                    while (!str.isEmpty()) { /* В программе читается весь входной поток */
                        System.out.println(str);
                        if (str.contains("GET /?msg=")) {
                            int index = str.indexOf("=");
                            String indexStr = str.substring(index + 1, str.indexOf(" ", index)); /* index + 1 -> после "=" */
                            if (indexStr.equals("Exit")) {
                                answer = "Завершаю работу сервера";
                            } else if (indexStr.equals("Hello")) {
                                answer = "Привет клиент";
                            } else {
                                answer = "What ?";
                            }
                        }
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                    if (answer.equals("Завершаю работу сервера")) {
                        server.close();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}
