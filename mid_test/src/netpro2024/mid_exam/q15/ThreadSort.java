package netpro2024.mid_exam.q15;

public class ThreadSort {

    public static void main(String[] args) {
        sortPrint(new int[]{3, 1, 4, 15, 9, 21});
    }

    public static void sortPrint(int[] arr) {
        Item[] items = new Item[arr.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(arr[i]);
        }
        for (int i = 0; i < items.length; i++) {
            new Thread(items[i]).start();
        }
    }

    static class Item implements Runnable {
        int n;

        Item(int n) {
            this.n = n;
        }

        public void run() {
            try {
                Thread.sleep(n * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(n);
        }
    }
}
