import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
        final int NUM_STUDENTS = 100;
        final int PASSING_SCORE = 80;

        // 100人の学生のランダムな点数を生成
        Random rand = new Random();
        int[] scores = new int[NUM_STUDENTS];
        for (int i = 0; i < NUM_STUDENTS; i++) {
            scores[i] = rand.nextInt(101); // 0から100までのランダムな点数
        }

        // 平均点を計算
        double averageScore = Arrays.stream(scores).average().orElse(0.0);
        System.out.printf("平均点は%.1f\n", averageScore);

        // 80点以上の合格者のリストを作成
        int[] passingScores = Arrays.stream(scores)
                                    .filter(score -> score >= PASSING_SCORE)
                                    .toArray();

        // 合格者の点数を昇順でソート
        Arrays.sort(passingScores);

        // 合格者の点数を表示
        System.out.println("以下合格者の点数です。");
        for (int score : passingScores) {
            System.out.println(score);
        }
    }
}
