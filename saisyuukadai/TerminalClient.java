package saisyuukadai;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class TerminalClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("メッセージを入力してください: ");
            String message = scanner.next();
            System.out.println("内容を入力してください: ");
            String content = scanner.next();
            scanner.close();

            TerminalInput input = new TerminalInput();
            input.setMessage(message);
            input.setContent(content);

            oos.writeObject(input);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TerminalInput response = (TerminalInput) ois.readObject();

            String replyMsg = response.getMessage();
            System.out.println("サーバからのメッセージ: " + replyMsg);
            String replyContent = response.getContent();
            System.out.println("内容: " + replyContent);

            ois.close();
            oos.close();
            socket.close();

        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
