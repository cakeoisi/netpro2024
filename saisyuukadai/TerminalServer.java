package saisyuukadai;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TerminalServer {

    private static final int times = 2;

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("Processed: ");
        for (int i = 0; i < times; i++) {
            sb.append(content).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port);

            Socket socket = server.accept();
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TerminalInput input = (TerminalInput) ois.readObject();

            String msg = input.getMessage();
            System.out.println("メッセージは: " + msg);
            String content = input.getContent();
            System.out.println("内容は: " + content);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            TerminalInput response = new TerminalInput();
            response.setMessage("サーバーからの返事: " + msg);
            response.setContent(serverProcess(content));

            oos.writeObject(response);
            oos.flush();

            ois.close();
            oos.close();
            socket.close();
            server.close();

        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
