package com.company;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Spring {
    public Spring(int x1, int y1, int x2, int y2, int w, int n) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.w = w;
        this.n = n;
    }

    int x1; int y1; int x2; int y2; int w; int n;
    void drawSpring(Graphics g)
    {
        // vector increment
        double inv = 0.25 / (double)n;
        double dx = (x2 - x1) * inv,
                dy = (y2 - y1) * inv;

        // perpendicular direction
        double inv2 = w / sqrt(dx * dx + dy * dy);
        double px =  dy * inv2,
                py = -dx * inv2;

        // loop
        double x = x1, y = y1;
        for (int i = 0; i < n; i++)
        {
            g.drawLine((int) x, (int) y,
                    (int) (x + dx + px), (int) (y + dy + py));
            g.drawLine((int) (x + dx + px), (int) (y + dy + py),
                    (int) (x + 3.0 * dx - px), (int) (y + 3.0 * dy - py));
            g.drawLine((int) (x + 3.0 * dx - px), (int) (y + 3.0 * dy - py),
                    (int) (x + 4.0 * dx), (int) (y + 4.0 * dy));
            x += 4.0 * dx;
            y += 4.0 * dy;
        }
    }
}
