package com.matheusvillela.flutter.plugins.qrcodereader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class PointsOverlayView extends View {
    private Paint paint;
    private int width;
    private int height;

    public PointsOverlayView(Context context) {
        super(context);
        init();
    }

    public PointsOverlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PointsOverlayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width  = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        int len = Math.min(width, height) + 2;
        setMeasuredDimension(len,len);
    }

    @Override public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawLine(0,0,width/ 4.0f,0,paint);
        canvas.drawLine(0,0,0,height/ 4.0f,paint);

        canvas.drawLine(width,0,width * 3/ 4.0f,0,paint);
        canvas.drawLine(width,0,width,height / 4.0f,paint);

        canvas.drawLine(0,height,0,height * 3 / 4.0f,paint);
        canvas.drawLine(0,height,width / 4.0f,height,paint);

        canvas.drawLine(width,height,width,height * 3/4.0f,paint);
        canvas.drawLine(width,height,width * 3/4.0f,height,paint);
    }
}
