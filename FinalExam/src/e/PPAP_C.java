package e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PPAP_C {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 12345;

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in);
        ) {
            String s1 = sendRequest(output, input, "pen,apple,reverse");
            String s2 = sendRequest(output, input, "pen,pineapple,sequence");

            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);

            String finalRequest = s1 + "," + s2 + ",reverse";
            String finalResponse = sendRequest(output, input, finalRequest);

            System.out.println("Final response: " + finalResponse);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    private static String sendRequest(PrintWriter output, BufferedReader input, String request) throws IOException {
        output.println(request);
        return input.readLine();
    }
}
