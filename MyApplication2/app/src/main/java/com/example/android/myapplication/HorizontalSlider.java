package com.example.android.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dell on 3/3/2017.
 */

public class HorizontalSlider extends View {
    public HorizontalSlider(Context context) {
        super(context);
    }

    Canvas canvas;
    Paint paintBack;
    Paint paintProgress;
    int progressColor;
    int backColor;
    int progress;

    public HorizontalSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HorizontalSlider);
        progressColor = array.getColor(R.styleable.HorizontalSlider_pcolor, Color.BLACK);
        backColor = array.getColor(R.styleable.HorizontalSlider_bcolor, Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        paintBack = new Paint();
        paintBack.setColor(backColor);
        paintProgress = new Paint();
        paintProgress.setColor(progressColor);
        canvas.drawRect(progress * canvas.getWidth() / 100, 0, canvas.getWidth(), 65, paintBack);
        canvas.drawRect(0, 0, progress * canvas.getWidth() / 100, 65, paintProgress);


    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
