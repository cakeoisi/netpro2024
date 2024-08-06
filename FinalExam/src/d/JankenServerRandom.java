package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class JankenServerRandom {
    private static int winCount = 0;
    private static int drawCount = 0;
    private static int loseCount = 0;

    public static void main(String[] args) {
        int portNumber = 5002;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Janken Server started on port " + portNumber);

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
        private Random random = new Random();

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            ) {
                String clientHand;
                while ((clientHand = input.readLine()) != null) {
                    String serverHand = generateServerHand();
                    String result = determineResult(clientHand, serverHand);
                    output.println(result);
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

        private String generateServerHand() {
            int hand = random.nextInt(3);
            switch (hand) {
                case 0:
                    return "Guu";
                case 1:
                    return "Choki";
                case 2:
                default:
                    return "Pa";
            }
        }

        private String determineResult(String clientHand, String serverHand) {
            if (clientHand.equals(serverHand)) {
                drawCount++;
                return "Draw. Server hand is " + serverHand + ". (Win,Draw,Lose)=(" + getWinRate() + "%," + getDrawRate() + "%," + getLoseRate() + "%)";
            } else if ((clientHand.equals("Guu") && serverHand.equals("Choki")) ||
                       (clientHand.equals("Choki") && serverHand.equals("Pa")) ||
                       (clientHand.equals("Pa") && serverHand.equals("Guu"))) {
                winCount++;
                return "You Win. Server hand is " + serverHand + ". (Win,Draw,Lose)=(" + getWinRate() + "%," + getDrawRate() + "%," + getLoseRate() + "%)";
            } else {
                loseCount++;
                return "You Lose. Server hand is " + serverHand + ". (Win,Draw,Lose)=(" + getWinRate() + "%," + getDrawRate() + "%," + getLoseRate() + "%)";
            }
        }

        private int getWinRate() {
            int total = winCount + drawCount + loseCount;
            return total == 0 ? 0 : (winCount * 100 / total);
        }

        private int getDrawRate() {
            int total = winCount + drawCount + loseCount;
            return total == 0 ? 0 : (drawCount * 100 / total);
        }

        private int getLoseRate() {
            int total = winCount + drawCount + loseCount;
            return total == 0 ? 0 : (loseCount * 100 / total);
        }
    }
}
