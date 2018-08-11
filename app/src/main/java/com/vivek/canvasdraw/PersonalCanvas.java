package com.vivek.canvasdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import static com.vivek.canvasdraw.MainActivity.screenHeight;
import static com.vivek.canvasdraw.MainActivity.screenWidth;

class PersonalCanvas extends View{
    private static final String TAG = "PersonalCanvas";
    private Paint mPaint;
    private Path mPath;

    int smallerCircle;
    int selectedColor;

    public PersonalCanvas(Context context) {
        super(context);

        init(null);
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(10);
        selectedColor = Color.BLACK;
        smallerCircle = 700;
        mPath = new Path();
    }

    public PersonalCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public PersonalCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public PersonalCanvas(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);

        mPaint.setColor(selectedColor);
        canvas.drawCircle(smallerCircle, screenHeight/2 + screenHeight/4, 25, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(100, screenHeight/2 + screenHeight/4, 50, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(300, screenHeight/2 + screenHeight/4, 50, mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(500, screenHeight/2 + screenHeight/4, 50, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(700, screenHeight/2 + screenHeight/4, 50, mPaint);
        mPaint.setColor(Color.CYAN);
        canvas.drawCircle(900, screenHeight/2 + screenHeight/4, 50, mPaint);

        mPaint.setColor(selectedColor);
        super.onDraw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                if (event.getY() < screenHeight/2 + screenHeight/4 - 100) mPath.moveTo(event.getX(), event.getY());

                int circleY = screenHeight/2 + screenHeight/4;
                Log.d(TAG, "onTouchEvent: YPosition: " + event.getX());
                Log.d(TAG, "onTouchEvent: " + (event.getY() >= circleY - 50));
                Log.d(TAG, "onTouchEvent: " + (event.getY() <= circleY + 50));
                Log.d(TAG, "onTouchEvent: " + (event.getX() >= 100));
                Log.d(TAG, "onTouchEvent: " + (event.getX() <= 150));
                if (event.getX() >= 50 && event.getX() <= 150 && event.getY() >= circleY - 50 && event.getY() <= circleY + 50){
                    Log.d(TAG, "onTouchEvent: circle: " + circleY);
                    selectedColor = Color.RED;
                    smallerCircle = 100;
                    mPath = new Path();
                    invalidate();
                }
                if (event.getX() >= 250 && event.getX() <= 350 && event.getY() >= circleY - 50 && event.getY() <= circleY + 50){
                    selectedColor = Color.GREEN;
                    smallerCircle = 300;
                    mPath = new Path();
                    invalidate();
                }
                if (event.getX() >= 450 && event.getX() <= 550 && event.getY() >= circleY - 50 && event.getY() <= circleY + 50){
                    selectedColor = Color.BLUE;
                    smallerCircle = 500;
                    mPath = new Path();
                    invalidate();
                }
                if (event.getX() >= 650 && event.getX() <= 750 && event.getY() >= circleY - 50 && event.getY() <= circleY + 50){
                    selectedColor = Color.BLACK;
                    smallerCircle = 700;
                    mPath = new Path();
                    invalidate();
                }
                if (event.getX() >= 850 && event.getX() <= 950 && event.getY() >= circleY - 50 && event.getY() <= circleY + 50){
                    selectedColor = Color.CYAN;
                    smallerCircle = 900;
                    mPath = new Path();
                    invalidate();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (event.getY() < screenHeight/2 + screenHeight/4 - 100) mPath.lineTo(event.getX(), event.getY());
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                break;

        }

        return true;
    }
}
