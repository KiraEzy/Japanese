package scm.cswong274.japaneseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;
/* * Code modified from class display extends view{} , found at:
    https://www.youtube.com/watch?v=4GYKOzgQDWI&ab_channel=CodingMark*/
public class DrawingActivity extends View {
    public android.graphics.Path path = new android.graphics.Path();
    public Paint paint = new Paint();
    TextView txt_word;
    ArrayList<android.graphics.Path> paths = new ArrayList<>();
    public ViewGroup.LayoutParams params;
    public int BrushColor = Color.BLACK;

    public DrawingActivity(Context context) {
        super(context);
        init(context);
    }
    public DrawingActivity(Context context, AttributeSet attr) {
        super(context, attr);
        init(context);
    }
    public DrawingActivity(Context context, AttributeSet attr, int style) {
        super(context, attr, style);
        init(context);
    }

    void init(Context context){
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(30f);
        Log.e("Drawing","Init");
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Log.e("Drawing","Touch");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.e("Drawing","Down");
                path.moveTo(x,y);
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("Drawing","Move");
                path.lineTo(x,y);
                paths.add(path);
                invalidate();
                return true;
        }
        return true;
    }

    public void clear(){
        paths.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i=0;i<paths.size();i++){
            paint.setColor(Color.BLACK);
            canvas.drawPath(paths.get(i),paint);
            invalidate();//Code tweaked from https://www.youtube.com/watch?v=JsNM6k32aKs&t=454s&ab_channel=programmingismypassion
        }
    }
}