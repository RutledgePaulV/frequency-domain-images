package com.github.rutledgepaulv.graphics;

import javax.swing.*;

public class Window extends JFrame {
    public Pane pane;

    public Window(int _width, int _height, String title) {
        setSize(_width + 16, _height + 39);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane = new Pane(_width, _height);
        add(pane);
    }

}
