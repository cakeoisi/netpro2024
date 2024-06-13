import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTFutagoKeiki {

    public static void main(String[] args) {
        new FacesAWTFutagoKeiki();
    }

    FacesAWTFutagoKeiki() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {

        private FaceObj[] fobjs;

        FaceFrame() {
            fobjs = new FaceObj[9];
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    fobjs[i + 3 * j] = new FaceObj();
                    fobjs[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
                    fobjs[i + 3 * j].setEmotionLevel(i, j);
                }
            }
        }

        public void paint(Graphics g) {
            for (FaceObj fobj : fobjs) {
                fobj.drawFace(g);
            }
        }

        private class FaceObj {
            private int x, y;
            private int emotionLevel;

            public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void setEmotionLevel(int i, int j) {
                this.emotionLevel = (i + j) % 3; // 簡単な例
            }

            public void drawFace(Graphics g) {
                drawRim(g);
                drawEye(g, 35);
                drawBrow(g, 30);
                drawNose(g, 40);
                drawMouth(g, 100);
            }

            private void drawRim(Graphics g) {
                g.setColor(Color.BLACK);
                g.drawOval(x, y, 200, 200);
            }

            private void drawEye(Graphics g, int r) {
                g.setColor(Color.BLACK);
                g.drawOval(x + 50, y + 60, r, r);
                g.drawOval(x + 120, y + 60, r, r);
            }

            private void drawBrow(Graphics g, int bx) {
                g.setColor(Color.BLACK);
                g.drawLine(x + 50, y + 50, x + 50 + bx, y + 50);
                g.drawLine(x + 120, y + 50, x + 120 + bx, y + 50);
            }

            private void drawNose(Graphics g, int nx) {
                g.setColor(Color.BLACK);
                g.drawLine(x + 100, y + 90, x + 100, y + 90 + nx);
            }

            private void drawMouth(Graphics g, int mx) {
                int xMiddle = x + 100;
                int yMiddle = y + 160;
                if (emotionLevel == 0) { // Happy
                    g.drawArc(xMiddle - mx / 2, yMiddle - 10, mx, 20, 0, -180);
                } else if (emotionLevel == 1) { // Sad
                    g.drawArc(xMiddle - mx / 2, yMiddle - 10, mx, 20, 0, 180);
                } else { // Neutral
                    g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
                }
            }
        }
    }
}
