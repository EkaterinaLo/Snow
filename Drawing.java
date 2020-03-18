package com.example.snow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

class Snowflake{
    float x, y;
    float  velocity = Float.parseFloat("0.01");
    float r;


    public Snowflake() {
        x = (float) Math.random();
        y = (float) Math.random();
        r = (float) (Math.random()*12)+5;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    void fall(){
        if (y + velocity < 1) {
            y += velocity;
        }
        else {
            y = y - 1;
        }

    }
}

public class Drawing extends View {
    Snowflake[] snowflakes;
    Paint paint = new Paint();
    float w;
    float h;

    public Drawing(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        w = canvas.getWidth();
        h = canvas.getHeight();
        canvas.drawColor(Color.GRAY);
        float x, y, r;
        for (int i = 0; i < snowflakes.length; i++) {
            x = (snowflakes[i].getX()) * w;
            y = (snowflakes[i].getY()) * h;
            r = snowflakes[i].getR();
            paint.setColor(Color.WHITE);
            canvas.drawCircle(x, y, r, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i].fall();
        }
        invalidate();
        return true;
    }

    public Drawing(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snowflakes = new Snowflake[120];
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake();
        }
    }
}


