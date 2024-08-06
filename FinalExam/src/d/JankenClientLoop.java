package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class JankenClientLoop {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 5002;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("send Janken Command to Server: ");
                String clientHand = scanner.nextLine();

                if (clientHand.equalsIgnoreCase("q")) {
                    break;
                }

                output.println(clientHand);

                String response = input.readLine();
                System.out.println("Response from Server: " + response);
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
