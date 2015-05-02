package com.example.benjaminhoover.dodgeball;

/**
 * Created by benjamin.hoover on 4/30/2015.
 */
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.format.Time;

import java.util.Formatter;

public class StatusMessage {
    private StringBuilder statusMsg = new StringBuilder();
    private Formatter formatter = new Formatter(statusMsg);
    private Paint paint;
    private float startTime;
    private Time time;
    public StatusMessage(int color) {
        paint = new Paint();
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(30);
        paint.setColor(color);
        startTime = 0;
    }

    public void update(Ball ball) {
        statusMsg.delete(0,statusMsg.length());
        if(ball.ballDead){
        }else{
            if(ball.start){
                startTime += Time.SECOND;
            }
        }
        formatter.format("Score: %2.0f", startTime);
    }

    public void draw(Canvas canvas) {
        canvas.drawText(statusMsg.toString(), 10, 60, paint);
    }
}

