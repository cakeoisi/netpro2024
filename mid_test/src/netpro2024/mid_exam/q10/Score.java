package netpro2024.mid_exam.q10;

public class Score {
    private int examID;
    private int mathScore;

    public void setExamID(int student_id) {
        this.examID = student_id;
    }

    public int getExamID() {
        return this.examID;
    }

    public void setMathScore(int m) {
        this.mathScore = m;
    }

    public int getMathScore() {
        return this.mathScore;
    }

    public void printGokaku() {
        if (mathScore >= 60) {
            String message = "";
            if (mathScore == 100) {
                message = "満点！エクセレント！";
            } else if (mathScore >= 95) {
                message = "ほぼ満点すばらしい！";
            }
            System.out.println("学籍番号 " + examID + " 点数 " + mathScore + " " + message);
        }
    }
}
