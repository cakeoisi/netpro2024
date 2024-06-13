package netpro2024.mid_exam.q11;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ItemsWriteCSV {
    public static void main(String[] args) {
        try {
            File csv = new File("q11_items.csv");
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true));
            LocalDateTime datetime1 = LocalDateTime.now();
            System.out.println("q11_items.csvを開きました。保存を開始します。");
            System.out.println("現在時刻 : " + datetime1);

            Scanner scanner = new Scanner(System.in);

            System.out.println("商品名を入力してください");
            String itemName = scanner.nextLine();
            System.out.println("入力値は「" + itemName + "」です。");

            System.out.println("値段を入力してください");
            String price = scanner.nextLine();
            System.out.println("入力値は「" + price + "」です。");

            bw.write(itemName + "," + price + "," + datetime1 + "\n");
            bw.close();

            System.out.println("q11_items.csvに書き込みました。終了します。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
