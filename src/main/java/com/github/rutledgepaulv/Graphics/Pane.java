package com.github.rutledgepaulv.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pane extends JPanel implements Runnable {

    private BufferedImage buffer;
    private int width, height;
    Thread runner = null;

    public Pane(int _width, int _height) {
        runner = new Thread(this);
        width = _width;
        height = _height;
        buffer = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_RGB);
        runner.start();
    }

    public void SetBuffer(Color[][] _buffer) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                buffer.setRGB(x, y, _buffer[x][y].getRGB());
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(buffer, 0, 0, width, height, null);
    }

    public void run() {
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
