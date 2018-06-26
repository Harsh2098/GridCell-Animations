package com.lemnistech.customdistortion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Circle extends View {

    private static final int START_ANGLE_POINT = 270;

    private final Paint paint;

    final int strokeWidth;
    int fullWidth, fullHeight;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        strokeWidth = 20;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(context.getColor(R.color.colorAccent));

        //size 200x200 example
        Log.v(":::", attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height"));

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        fullHeight = h;
        fullWidth = w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(strokeWidth, strokeWidth, fullWidth * 0.9f, fullHeight * 0.9f, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
