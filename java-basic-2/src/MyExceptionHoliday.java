import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyExceptionHoliday {
    private static final Set<Integer> HOLIDAYS = new HashSet<>(Arrays.asList(3, 4, 5)); // 例: 憲法記念日、みどりの日、こどもの日

    public static void main(String[] args) {
        MyExceptionHoliday holidayTest = new MyExceptionHoliday();
        holidayTest.run();
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("5月の何日ですか? (終了するには'q'を入力): ");
                String line = reader.readLine();

                if (line.equalsIgnoreCase("q")) {
                    System.out.println("プログラムを終了します。");
                    break;
                }

                int day = Integer.parseInt(line);

                if (day < 1 || day > 31) {
                    System.out.println("1日から31日の間で入力してください。");
                    continue;
                }

                checkHoliday(day);
                System.out.println(day + "日は休日または土日です。");

            } catch (IOException e) {
                System.err.println("入力エラーが発生しました: " + e.getMessage());
            } catch (NoHolidayException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("数字を入力してください。");
            }
        }
    }

    private void checkHoliday(int day) throws NoHolidayException {
        // 土日か、特定の休日をチェック
        if (day % 7 == 0 || day % 7 == 6 || HOLIDAYS.contains(day)) {
            return; // 休日または土日
        }

        // それ以外は例外をスロー
        throw new NoHolidayException(day + "日は平日です。");
    }
}
