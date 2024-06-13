package netpro2024.mid_exam.q17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleAddressClient {
    public static void main(String[] args) {
        String townName = "千住曙町"; // 町名を変更する場合はここを変更

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
