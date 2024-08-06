package e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PPAP_S {
    public static void main(String[] args) {
        int portNumber = 12345;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("PPAP Server started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String clientMessage;
                while ((clientMessage = input.readLine()) != null) {
                    String response = processRequest(clientMessage);
                    output.println(response);
                }
            } catch (IOException e) {
                System.err.println("ClientHandler error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        private String processRequest(String request) {
            String[] parts = request.split(",");
            if (parts.length != 3) {
                return "Invalid request format";
            }

            String firstWord = capitalize(parts[0]);
            String secondWord = capitalize(parts[1]);
            String command = parts[2];

            if (command.equals("reverse")) {
                return secondWord + "-" + firstWord;
            } else if (command.equals("sequence")) {
                return firstWord + "-" + secondWord;
            } else {
                return "Invalid command";
            }
        }

        private String capitalize(String word) {
            if (word.isEmpty()) {
                return word;
            }
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
    }
}
