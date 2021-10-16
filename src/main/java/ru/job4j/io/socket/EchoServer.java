package ru.job4j.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                        if (str.contains("?msg=Exit")) {
                            server.close();
                            out.write("This server is disabled".getBytes());
                            System.out.println("This server is disabled");
                            break;
                        } else if (str.contains("?msg=Hello")) {
                            out.write("Hello".getBytes());
                        } else {
                            StringBuilder requestOut = new StringBuilder("http://localhost:");
                            out.write(requestOut.append(server.getLocalPort())
                                                .append(str.split(" ")[1])
                                                .toString().getBytes());
                        }
                        System.out.println(str);
                        for (str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                            System.out.println(str);
                        }
                        out.flush();
                    }
                }
            }
        }
    }
