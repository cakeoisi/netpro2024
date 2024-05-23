import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClientOnce {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            ITask task = new TaskObject();
            task.setExecNumber(100); // 100以下の最大素数を求める
            oos.writeObject(task);

            ITask resultTask = (ITask) ois.readObject();
            int result = resultTask.getResult();

            System.out.println("サーバからの計算結果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
