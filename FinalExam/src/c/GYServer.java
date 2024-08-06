package c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GYServer {
    public static void main(String[] args) {
        int portNumber = 12345;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static String convertToEra(int year) {
        if (year >= 2019) {
            return "令和" + (year - 2018);
        } else if (year >= 1989) {
            return "平成" + (year - 1988);
        } else if (year >= 1926) {
            return "昭和" + (year - 1925);
        } else if (year >= 1912) {
            return "大正" + (year - 1911);
        } else if (year >= 1868) {
            return "明治" + (year - 1867);
        } else {
            return "元号範囲外";
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
                    if (clientMessage.equalsIgnoreCase("q")) {
                        break;
                    }
                    try {
                        int year = Integer.parseInt(clientMessage);
                        String era = convertToEra(year);
                        output.println(era);
                    } catch (NumberFormatException e) {
                        output.println("Invalid input. Please enter a valid year.");
                    }
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
    }
}
