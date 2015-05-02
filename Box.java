package com.example.benjaminhoover.dodgeball;

/**
 * Created by benjamin.hoover on 4/30/2015.
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Box {
    public int xMin, xMax, yMin, yMax;

    public Box(int color) {
    }

    public void set(int x, int y, int width, int height) {
        xMin = x;
        xMax = x + width - 1;
        yMin = y;
        yMax = y + height - 1;
    }

    public void draw(Canvas canvas) {
    }
}
