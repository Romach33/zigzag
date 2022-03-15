package com.company;

import java.awt.*;
import javax.swing.*;

import static java.lang.Math.sqrt;

public class DrawPanel extends JFrame {

    int x1;
    int x2;
    int y1;
    int y2;
    int w;
    int n;

    DrawPanel(int x1, int y1, int x2, int y2, int w, int n) {
        this.n=n;
        this.x2 = x2;
        this.x1 = x1;
        this.w = w;
        this.y1 = y1;
        this.y2 = y2;
        this.setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.repaint();
    }

    public void paint(Graphics g) {
        Spring sp = new Spring(x1,y1,x2,y2,w,n);
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.black);
        sp.drawSpring(g);
    }

    public static void doIt(int x1, int y1, int x2, int y2, int w, int n) {
        DrawPanel component = new DrawPanel(x1, y1, x2, y2, w, n);
    }
}