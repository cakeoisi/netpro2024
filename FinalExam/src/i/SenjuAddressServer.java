package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SenjuAddressServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("サーバがポート8088で起動しました。");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String townName = in.readLine();
                    String postalCode = getPostalCode(townName);

                    out.println(postalCode);
                    System.out.println("町名: " + townName + " の郵便番号は " + postalCode + " です。");
                } catch (IOException e) {
                    System.err.println("クライアントとの通信中にエラーが発生しました: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("サーバの起動中にエラーが発生しました: " + e.getMessage());
        }
    }

    private static String getPostalCode(String townName) {
        switch (townName) {
            case "千住曙町":
                return "120-0023";
            case "千住旭町":
                return "120-0026";
            case "千住東":
                return "120-0025";
            case "千住大川町":
                return "120-0024";
            case "千住関屋町":
                return "120-0022";
            case "千住宮元町":
                return "120-0021";
            case "千住仲町":
                return "120-0032";
            case "千住橋戸町":
                return "120-0033";
            case "千住緑町":
                return "120-0034";
            default:
                return "郵便番号が見つかりません";
        }
    }
}
