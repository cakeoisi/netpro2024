package b;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ExamMaxAveMain {
    public static void main(String[] args) {
        Random random = new Random();
        List<ExamScores> students = new ArrayList<>();
        List<ExamScores> passedStudents = new ArrayList<>();

        // 3000名の受験生の点数をランダムに生成しセット
        for (int i = 1; i <= 3000; i++) {
            ExamScores student = new ExamScores();
            student.setExamId(i);
            student.setMathScore(random.nextInt(101));
            student.setEngScore(random.nextInt(101));
            student.setPhysicsScore(random.nextInt(101));

            students.add(student);

            if (student.isPass()) {
                passedStudents.add(student);
            }
        }

        // 合格者を成績順にソート
        Collections.sort(passedStudents, new Comparator<ExamScores>() {
            @Override
            public int compare(ExamScores s1, ExamScores s2) {
                return Float.compare(s2.getAverageScore(), s1.getAverageScore());
            }
        });

        // 合格者一覧をファイルに保存し、コンソールに出力
        try (FileWriter writer = new FileWriter("B_Gokaku.txt")) {
            for (ExamScores student : passedStudents) {
                System.out.println(student);
                writer.write(student + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
