package com.spark.alphabet;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TracingView extends View {

    private Paint tracePaint;
    private Path tracePath;
    private String letter = "अ";
    private Paint letterPaint;

    public TracingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        tracePath = new Path();

        tracePaint = new Paint();
        tracePaint.setColor(Color.RED);
        tracePaint.setStyle(Paint.Style.STROKE);
        tracePaint.setStrokeWidth(32f);
        tracePaint.setStrokeJoin(Paint.Join.ROUND);

        letterPaint = new Paint();
        letterPaint.setColor(Color.LTGRAY);
        letterPaint.setTextSize(600f);
        letterPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xPos = getWidth() / 2;
        int yPos = (int)((getHeight() / 2) - ((letterPaint.descent() + letterPaint.ascent()) / 2));

        // Draw letter in background
        canvas.drawText(letter, xPos, yPos, letterPaint);

        // Draw traced path
        canvas.drawPath(tracePath, tracePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                tracePath.moveTo(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                tracePath.lineTo(x, y);
                break;
        }
        invalidate();
        return true;
    }

    public void clearPath() {
        tracePath.reset();
        invalidate();
    }

    public void setLetterToTrace(String letter) {
        this.letter = letter;
        invalidate();
    }
}
