public class IPAdress {
    
}
IPアドレスからホスト名を取り出す実験
// IP Address
InetAddress addr
       = InetAddress.getByName("8.8.8.8");
// Host name
System.out.println("Host name is: "
       + addr.getHostName());
// Host Address
System.out.println("Ip address is: "
       + addr.getHostAddress());
       

//ipの調べ方 ターミナルで以下のコマンド
>ipconfig
>ifconfig

