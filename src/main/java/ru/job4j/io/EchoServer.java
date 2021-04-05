package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
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
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Bye")) {
                            server.close();
                        }
                        str = in.readLine();
                    }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    }
                }
            }
        }
}
