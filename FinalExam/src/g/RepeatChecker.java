package g;

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
        // text の長さが 3 の倍数であれば true を返す
        return text.length() % 3 == 0;
    }

    public static boolean isTripleRepeat(String text) {
        // text が任意の文字列 3回 の繰り返しになっていたら true を返す
        if (text.length() % 3 != 0) {
            return false;
        }
        int len = text.length() / 3;
        String part = text.substring(0, len);
        return text.equals(part + part + part);
    }

    public static boolean isSemiTripleRepeat(String text) {
        // text が 大小文字を区別せず 任意の文字列 3回 の繰り返しになっていたら true を返す
        if (text.length() % 3 != 0) {
            return false;
        }
        int len = text.length() / 3;
        String part = text.substring(0, len).toLowerCase();
        String lowerText = text.toLowerCase();
        return lowerText.equals(part + part + part);
    }
}
