package j;

public class SumCalculator implements Runnable {
        private int threadNumber;
    
        public SumCalculator(int threadNumber) {
            this.threadNumber = threadNumber;
        }
    
        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            System.out.println("スレッド " + threadNumber + " の計算結果: " + sum);
        }
    
        public static void main(String[] args) {
            Thread[] threads = new Thread[50];
    
            for (int i = 0; i < 50; i++) {
                threads[i] = new Thread(new SumCalculator(i));
                threads[i].start();
            }
    
            for (int i = 0; i < 50; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    System.err.println("スレッド " + i + " が中断されました: " + e.getMessage());
                }
            }
    
            System.out.println("すべてのスレッドが終了しました。");
        }
    }
    