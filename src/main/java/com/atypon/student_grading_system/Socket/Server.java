//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server implements AutoCloseable {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Server started on port " + port);
    }

    public void acceptClients() throws IOException {
        while(!this.serverSocket.isClosed()) {
            Socket client = this.serverSocket.accept();
            System.out.println("New client connected: " + client.getInetAddress().getHostAddress());
            (new Thread(new ClientHandler(client))).start();
        }

    }

    public void close() throws IOException {
        if (this.serverSocket != null && !this.serverSocket.isClosed()) {
            this.serverSocket.close();
            System.out.println("Server closed.");
        }

    }

    public static void main(String[] args) {
        try (Server server = new Server(1234)) {
            server.acceptClients();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
