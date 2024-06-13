package netpro2024.mid_exam.q14;

public class RepeatChecker {
    public static void main(String[] args) {
        System.out.println("* isTripleLength");
        System.out.println(isTripleLength("123")); // true
        System.out.println(isTripleLength("ab.cd")); // false

        System.out.println("\n* isTripleRepeat");
        System.out.println(isTripleRepeat("WordWordWord")); // true
        System.out.println(isTripleRepeat("...")); // true
        System.out.println(isTripleRepeat("WordWordWord.")); // false
        System.out.println(isTripleRepeat("ABCABCAbc")); // false

        System.out.println("\n* isSemiTripleRepeat");
        System.out.println(isSemiTripleRepeat("ABC.ABc.abc.")); // true
        System.out.println(isSemiTripleRepeat("AbcAbc")); // false
    }

    public static boolean isTripleLength(String text) {
        return text.length() % 3 == 0;
    }

    public static boolean isTripleRepeat(String text) {
        if (text.length() % 3 != 0) {
            return false;
        }
        int len = text.length() / 3;
        String part1 = text.substring(0, len);
        String part2 = text.substring(len, 2 * len);
        String part3 = text.substring(2 * len);
        return part1.equals(part2) && part2.equals(part3);
    }

    public static boolean isSemiTripleRepeat(String text) {
        if (text.length() % 3 != 0) {
            return false;
        }
        int len = text.length() / 3;
        String part1 = text.substring(0, len).toLowerCase();
        String part2 = text.substring(len, 2 * len).toLowerCase();
        String part3 = text.substring(2 * len).toLowerCase();
        return part1.equals(part2) && part2.equals(part3);
    }
}
