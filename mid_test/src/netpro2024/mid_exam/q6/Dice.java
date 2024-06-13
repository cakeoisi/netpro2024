package netpro2024.mid_exam.q6;

import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("サイコロを振るにはEnterキーを押してください。終了するにはquit、exit、または0を入力してください。");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit") || input.equals("0")) {
                System.out.println("Diceプログラム終了します。");
                break;
            }

            int roll = random.nextInt(6) + 1;
            count++;
            System.out.println(roll + "(累計" + count + "回目)");
        }

        scanner.close();
    }
}
