package com.spark.alphabet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TracingView extends View {

    private Paint paint;
    private Path path;
    private String letter = "अ";

    public TracingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(12f);
        paint.setAntiAlias(true);
        path = new Path();
    }

    public void setPaintColor(int color) {
        paint.setColor(color);
        invalidate();
    }

    public void clearCanvas() {
        path.reset();
        invalidate();
    }

    public void setLetter(String letter) {
        this.letter = letter;
        clearCanvas();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw letter in background
        Paint textPaint = new Paint();
        textPaint.setColor(Color.LTGRAY);
        textPaint.setTextSize(600f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(letter, getWidth() / 2f, getHeight() / 1.5f, textPaint);

        // Draw tracing path
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}
