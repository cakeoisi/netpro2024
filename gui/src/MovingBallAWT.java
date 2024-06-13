import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MovingBallAWT {
    public static void main(String[] args) {
        FFrame f = new FFrame();
        f.setSize(500, 500);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    static class FFrame extends Frame implements Runnable {
        Thread th;
        Ball[] balls;
        private boolean enable = true;
        private int counter = 0;
        private final int NUM_BALLS = 5;

        FFrame() {
            balls = new Ball[NUM_BALLS];
            th = new Thread(this);
            th.start();
        }

        public void run() {
            Random rand = new Random();

            for (int i = 0; i < NUM_BALLS; i++) {
                balls[i] = new Ball();
                balls[i].setPosition(rand.nextInt(400) + 50, rand.nextInt(400) + 50);
                balls[i].setR(rand.nextInt(15) + 10);
                balls[i].setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            }

            while (enable) {
                try {
                    Thread.sleep(100);
                    counter++;
                    if (counter >= 200) enable = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (Ball ball : balls) {
                    ball.move();
                }

                repaint();  // paint()メソッドが呼び出される
            }
        }

        public void paint(Graphics g) {
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        // Ball というインナークラスを作る
        class Ball {
            int x, y, r; // 半径
            Color c = Color.RED;
            int xDir = 1;  // 1:+方向  -1: -方向
            int yDir = 1;

            void setColor(Color c) {
                this.c = c;
            }

            void move() {
                if ((xDir == 1 && x >= 450 - r) || (xDir == -1 && x <= r)) {
                    xDir = -xDir;
                }
                if ((yDir == 1 && y >= 450 - r) || (yDir == -1 && y <= r)) {
                    yDir = -yDir;
                }

                x += xDir * 10;
                y += yDir * 10;
            }

            void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            void setR(int r) {
                this.r = r;
            }

            void draw(Graphics g) {
                g.setColor(c);
                g.fillOval(x - r, y - r, 2 * r, 2 * r);  // rは半径なので2倍にする
            }
        }
    }
}
