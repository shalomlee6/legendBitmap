package com.slp.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

public class LegendLayout extends View {
    Context context;
    Legend legend;

    Paint gray_paint, blue_paint;

    public LegendLayout(Context context) {
        super(context);
        this.context = context;
        legend = new Legend(context);




    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        gray_paint = new Paint();
        blue_paint = new Paint();

        gray_paint.setColor(Color.GRAY);
        blue_paint.setColor(Color.BLUE);



        gray_paint.setStyle(Paint.Style.FILL);

//        Paint paint = new Paint();
//
//        canvas.drawColor(Color.GREEN);
//
//        Bitmap b = Bitmap.createBitmap(400, 400, Bitmap.Config.ALPHA_8);
//        Canvas c = new Canvas(b);
//        c.drawRect(0, 0, 400, 400, paint);
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
//        paint.setTextSize(40);
//        paint.setTextScaleX(1.f);
//        paint.setAlpha(0);
//        paint.setAntiAlias(true);
//        c.drawText("Your text", 30, 40, paint);
//        paint.setColor(Color.RED);
//
//        canvas.drawBitmap(b, 10,10, paint);
//https://jimbaca.com/what-is-canvas-in-android/
        Rect firstRect = new Rect();
        Rect secondRect = new Rect();
        firstRect.set(legend.getBitmapOverlay().getWidth()/2, 0,getWidth(),legend.getBitmapOverlay().getHeight()/2);
        secondRect.set(legend.getBitmapOverlay().getWidth()/2, legend.getBitmapOverlay().getHeight()/2, getWidth(),legend.getBitmapOverlay().getHeight());
        canvas.drawBitmap(legend.getBitmapOverlay() ,legend.getX(),legend.getBmp1_y(),null );

        canvas.drawRect(firstRect,gray_paint);
        canvas.drawRect(secondRect,blue_paint);


    }
}
