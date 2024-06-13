package netpro2024.mid_exam.q5;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyGetMyPCIPv4 {

    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            System.out.println(ipAddress);
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }
    }
}
