package netpro2024.mid_exam.q2;

public class Kuku {
    public static void main(String args[]) {
        for (int i = 1; i <= 9; i++) {
            System.out.print("|");
            for (int j = 1; j <= 9; j++) {
                int product = i * j;
                if (product < 10) {
                    System.out.print(" " + product + "|");
                } else {
                    System.out.print(product + "|");
                }
            }
            System.out.println();
        }
    }
}
