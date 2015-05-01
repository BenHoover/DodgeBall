package com.example.benjaminhoover.dodgeball;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class DodgeBall extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View bouncingBallView = new DodgeBallView(this);
        setContentView(bouncingBallView);
        bouncingBallView.setBackgroundColor(Color.BLACK);
    }
}