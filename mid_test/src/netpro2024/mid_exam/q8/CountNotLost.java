package netpro2024.mid_exam.q8;

public class CountNotLost {
    public static void main(String[] args) {
        String[] strs = new String[]{"lost", "lost", "ok", "ok", "ok"};
        System.out.println(countNotLost(strs)); // 3
        String[] strs2 = new String[]{"a", "b", "c", "d"};
        System.out.println(countNotLost(strs2)); // 4
    }

    public static int countNotLost(String[] strs) {
        int count = 0;
        for (String str : strs) {
            if (!str.equals("lost")) {
                count++;
            }
        }
        return count;
    }
}
