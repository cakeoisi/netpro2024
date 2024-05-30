public class CountAZTenRunnable implements Runnable {
    private char character;

    public void setChar(char character) {
        this.character = character;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(character + "" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (char c = 'a'; c <= 'z'; c++) {
            CountAZTenRunnable task = new CountAZTenRunnable();
            task.setChar(c);
            Thread thread = new Thread(task, "thread-" + c);
            thread.start();
        }
    }
}
