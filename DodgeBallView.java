package com.example.benjaminhoover.dodgeball;

/**
 * Created by benjamin.hoover on 4/30/2015.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class DodgeBallView extends View {
    private Ball ball, ball2,ball3,ball4,ball5;
    private Box box;
    private Rock rock;
    private StatusMessage statusMsg;


    public DodgeBallView(Context context) {
        super(context);

        box = new Box(0xFFFFFF00);
        ball = new Ball(0xFFFF8000);
        ball2 = new Ball(0xFFFF8000);
        ball3 = new Ball(0xFFFF8000);
        ball4 = new Ball(0xFFFF8000);
        ball5 = new Ball(0xFFFF8000);
        rock = new Rock(0xaa000000);
        ball.ballRadius = 30;
        ball2.ballRadius = 35;
        ball3.ballRadius = 40;
        ball4.ballRadius = 45;
        ball5.ballRadius = 50;
        ball.ballSpeedX = 25;
        ball.ballSpeedY = 15;
        ball2.ballSpeedX = 30;
        ball2.ballSpeedY = 20;
        ball3.ballSpeedX = 35;
        ball3.ballSpeedY = 25;
        ball4.ballSpeedX = 25;
        ball4.ballSpeedY = 15;
        ball5.ballSpeedX = 20;
        ball5.ballSpeedY = 20;
        statusMsg = new StatusMessage(0xFFFFFFFF);

        this.setFocusableInTouchMode(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        rock.draw(canvas);
        ball.draw(canvas);
        ball2.draw(canvas);
        ball3.draw(canvas);
        ball4.draw(canvas);
        ball5.draw(canvas);
        statusMsg.draw(canvas);

        ball.moveWithCollisionDetection(box, rock);
        ball2.moveWithCollisionDetection(box,rock);
        ball3.moveWithCollisionDetection(box, rock);
        ball4.moveWithCollisionDetection(box, rock);
        ball5.moveWithCollisionDetection(box, rock);
        statusMsg.update(ball);


        try {
            Thread.sleep(30);
        } catch (InterruptedException e) { }

        invalidate();
    }

    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        box.set(0, 0, w, h);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ball.start = true;
        if(ball.ballDead || ball2.ballDead || ball3.ballDead || ball4.ballDead || ball5.ballDead){
            ball.ballDead = true;
            ball.ballSpeedX = 0;
            ball.ballSpeedY = 0;
            ball2.ballSpeedX = 0;
            ball2.ballSpeedY = 0;
            ball3.ballSpeedX = 0;
            ball3.ballSpeedY = 0;
            ball4.ballSpeedX = 0;
            ball4.ballSpeedY = 0;
            ball5.ballSpeedX = 0;
            ball5.ballSpeedY = 0;
        }else{
            rock.rockX = event.getX();
            rock.rockY = event.getY();
        }
        return true;
    }
}

