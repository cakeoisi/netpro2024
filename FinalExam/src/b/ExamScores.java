package b;
public class ExamScores {
    private int examId;
    private int mathScore;
    private int engScore;
    private int physicsScore;

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getExamId() {
        return examId;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setPhysicsScore(int physicsScore) {
        this.physicsScore = physicsScore;
    }

    public int getPhysicsScore() {
        return physicsScore;
    }

    public float getAverageScore() {
        return (float) Math.ceil((mathScore + engScore + physicsScore) / 3.0);
    }

    public boolean isPass() {
        if (mathScore == 100) {
            return true;
        }
        return getAverageScore() >= 85;
    }

    public String toString() {
        return "ID: " + examId + ", Math: " + mathScore + ", English: " + engScore + ", Physics: " + physicsScore;
    }
}
