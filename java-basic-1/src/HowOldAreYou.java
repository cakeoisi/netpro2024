import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("何歳ですか？(qまたはeで終了)");
                String input = reader.readLine();

                if (input.equals("q") || input.equals("e")) {
                    System.out.println("終了します。");
                    break;
                }

                int age = Integer.parseInt(input);

                // 年齢がマイナスまたは120以上の場合は再入力を促す
                if (age < 0 || age >= 120) {
                    System.out.println("年取りすぎ。再入力してください。");
                    continue;
                }

                // 元号と誕生年を表示
                String gengo = getGengo(age);
                int gengoYear = getGengoYear(age);
                System.out.println("あなたは2030年に" + (age + 6) + "歳です。");
                System.out.println("あなたの誕生年は、" + gengo + gengoYear + "年です。");

            } catch (IOException | NumberFormatException e) {
                System.out.println("入力エラーが発生しました。再入力してください。");
            }
        }
    }

    // 元号を取得するメソッド
    private static String getGengo(int age) {
        int birthYear = java.time.Year.now().getValue() - age;
        if (birthYear >= 2019) {
            return "令和";
        } else if (birthYear >= 1989) {
            return "平成";
        } else if (birthYear >= 1926) {
            return "昭和";
        } else if (birthYear >= 1912) {
            return "大正";
        } else {
            return "明治";
        }
    }

    // 元号年を取得するメソッド
    private static int getGengoYear(int age) {
        int birthYear = java.time.Year.now().getValue() - age;
        String gengo = getGengo(age);
        switch (gengo) {
            case "令和":
                return birthYear - 2018;
            case "平成":
                return birthYear - 1988;
            case "昭和":
                return birthYear - 1925;
            case "大正":
                return birthYear - 1911;
            case "明治":
                return birthYear - 1867;
            default:
                return -1; // エラーの場合は-1を返す
        }
    }
}
