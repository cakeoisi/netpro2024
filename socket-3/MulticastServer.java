import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
    public static void main(String[] args) {
        try {
            MulticastSocket socket = new MulticastSocket();
            InetAddress group = InetAddress.getByName("230.0.0.0");
            String message = "Hello, Multicast!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);
            socket.send(packet);
            System.out.println("Multicast message sent: " + message);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
