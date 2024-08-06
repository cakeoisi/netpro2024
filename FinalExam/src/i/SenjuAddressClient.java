package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SenjuAddressClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("町名を入力してください。\n>");
            String townName = scanner.nextLine();

            try (Socket socket = new Socket("localhost", 8088);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println(townName);

                String postalCode = in.readLine();
                System.out.println("町名: " + townName + " の郵便番号は " + postalCode + " です。");
            } catch (IOException e) {
                System.err.println("サーバとの通信中にエラーが発生しました: " + e.getMessage());
            }
        }
    }
}
