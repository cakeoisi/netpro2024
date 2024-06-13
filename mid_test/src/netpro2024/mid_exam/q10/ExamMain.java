package netpro2024.mid_exam.q10;

import java.util.Random;

public class ExamMain {
    public static void main(String[] args) {
        Random random = new Random();
        Score[] students = new Score[100];

        for (int i = 0; i < 100; i++) {
            students[i] = new Score();
            students[i].setExamID(i + 1);
            students[i].setMathScore(random.nextInt(101));
        }

        for (Score student : students) {
            student.printGokaku();
        }
    }
}
