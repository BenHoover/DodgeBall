package com.example.benjaminhoover.dodgeball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by benjamin.hoover on 5/2/2015.
 */
public class Rock {
    private float rockRadius = 15;
    float rockX = rockRadius + 200000;
    float rockY = rockRadius + 200000;
    public RectF rockBounds;
    private Paint paint;

    public Rock(int color) {
        rockBounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
    }
    public void draw(Canvas canvas) {
        rockBounds.set(rockX-rockRadius, rockY-rockRadius, rockX+rockRadius, rockY+rockRadius);
        canvas.drawOval(rockBounds,paint);
    }
}

