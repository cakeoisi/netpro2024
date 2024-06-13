import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {
    int x, y, w, h;

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setSize(int w, int h) {
        this.w = w;
        this.h = h;
    }

    void makeFace(Graphics g, String emotion) {
        // 顔の中心
        int cx = x + w / 2;
        int cy = y + h / 2;

        // 目の位置とサイズ
        int eyeY = y + h / 3;
        int eyeSize = w / 8;
        int eyeXOffset = w / 4;

        // 口の位置とサイズ
        int mouthY = y + (2 * h) / 3;
        int mouthWidth = w / 4;
        int mouthHeight = h / 8;

        // 目を描画
        g.setColor(Color.black);
        g.fillOval(cx - eyeXOffset - eyeSize / 2, eyeY, eyeSize, eyeSize);
        g.fillOval(cx + eyeXOffset - eyeSize / 2, eyeY, eyeSize, eyeSize);

        // 感情に基づいた口を描画
        switch (emotion) {
            case "smile":
                g.drawArc(cx - mouthWidth / 2, mouthY, mouthWidth, mouthHeight, 0, -180);
                break;
            case "angry":
                g.drawLine(cx - mouthWidth / 2, mouthY, cx + mouthWidth / 2, mouthY);
                break;
            case "normal":
            default:
                g.drawLine(cx - mouthWidth / 2, mouthY + mouthHeight / 2, cx + mouthWidth / 2, mouthY + mouthHeight / 2);
                break;
        }

        // 眉毛の描画
        int browY = eyeY - eyeSize / 2;
        int browWidth = eyeSize;
        int browHeight = eyeSize / 4;

        switch (emotion) {
            case "angry":
                g.drawLine(cx - eyeXOffset - browWidth / 2, browY, cx - eyeXOffset + browWidth / 2, browY - browHeight);
                g.drawLine(cx + eyeXOffset - browWidth / 2, browY - browHeight, cx + eyeXOffset + browWidth / 2, browY);
                break;
            case "smile":
                g.drawLine(cx - eyeXOffset - browWidth / 2, browY - browHeight, cx - eyeXOffset + browWidth / 2, browY);
                g.drawLine(cx + eyeXOffset - browWidth / 2, browY, cx + eyeXOffset + browWidth / 2, browY - browHeight);
                break;
            case "normal":
            default:
                g.drawLine(cx - eyeXOffset - browWidth / 2, browY, cx - eyeXOffset + browWidth / 2, browY);
                g.drawLine(cx + eyeXOffset - browWidth / 2, browY, cx + eyeXOffset + browWidth / 2, browY);
                break;
        }
    }
}
