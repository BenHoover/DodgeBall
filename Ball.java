package com.example.benjaminhoover.dodgeball;

/**
 * Created by benjamin.hoover on 4/30/2015.
 */
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import java.util.Random;

public class Ball {
    public int ballRadius = 30;
    float ballX = ballRadius + randInt(0,600);
    float ballY = ballRadius + randInt(0,1200);
    public int ballSpeedX = 30;
    public int ballSpeedY = 15;
    private RectF ballBounds;
    private Paint paint;
    private Random rand;
    public Boolean ballDead = false;
    public Boolean start = false;

    public Ball(int color) {
        ballBounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
        rand = new Random();
    }
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void moveWithCollisionDetection(Box box, Rock rock) {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        if (ballX + ballRadius > box.xMax) {
            ballSpeedX = -ballSpeedX;
            ballX = box.xMax-ballRadius;
            randomColor();
        } else if (ballX - ballRadius < box.xMin) {
            ballSpeedX = -ballSpeedX;
            ballX = box.xMin+ballRadius;
            randomColor();
        }
        if (ballY + ballRadius > box.yMax) {
            ballSpeedY = -ballSpeedY;
            ballY = box.yMax - ballRadius;
            randomColor();
        } else if (ballY - ballRadius < box.yMin) {
            ballSpeedY = -ballSpeedY;
            ballY = box.yMin + ballRadius;
            randomColor();
        }

        //Detect collision with rock
        if(ballBounds.contains(rock.rockBounds)){
            ballDead = true;
            ballSpeedX = 0;
            ballSpeedY = 0;
        }
    }
    public void randomColor() {
        paint.setColor(rand.nextInt(0xFFFFFF) + 0xFF000000);
    }

    public void draw(Canvas canvas) {
        ballBounds.set(ballX-ballRadius, ballY-ballRadius, ballX+ballRadius, ballY+ballRadius);
        canvas.drawOval(ballBounds,paint);
    }
}
