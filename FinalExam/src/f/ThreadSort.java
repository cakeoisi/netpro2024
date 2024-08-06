package f;

public class ThreadSort {

    public static void main(String[] args) {
        // int の配列を与える
        sortPrint(new int[]{3, 1, 4, 15, 9, 21});
    }

    public static void sortPrint(int[] arr) {
        ItemTh[] items = new ItemTh[arr.length];

        for (int i = 0; i < items.length; i++) {
            // 各スレッドクラスをセットアップ
            items[i] = new ItemTh(arr[i]);
            new Thread(items[i]).start();
        }
    }

    static class ItemTh implements Runnable {
        int n;

        ItemTh(int n) {
            this.n = n;
        }

        public void run() {
            try {
                // sleep の時間は n * 100ms とする
                Thread.sleep(n * 100);
                System.out.println(n);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

