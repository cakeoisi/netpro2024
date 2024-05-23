import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("数値を入力してください（1以下で終了）: ");
                int input = scanner.nextInt();

                if (input <= 1) {
                    System.out.println("クライアントを終了します。");
                    break;
                }

                try (Socket socket = new Socket("localhost", 12345);
                     ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                     ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                    ITask task = new TaskObject();
                    task.setExecNumber(input);
                    oos.writeObject(task);

                    ITask resultTask = (ITask) ois.readObject();
                    int result = resultTask.getResult();

                    System.out.println("サーバからの計算結果: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
