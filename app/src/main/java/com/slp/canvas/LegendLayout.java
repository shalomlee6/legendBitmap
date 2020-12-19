package com.slp.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

        Rect firstRect = new Rect();
        Rect secondRect = new Rect();
        firstRect.set(legend.getBitmapOverlay().getWidth(), 0,getWidth(),legend.getBitmapOverlay().getHeight()/2);
        secondRect.set(legend.getBitmapOverlay().getWidth(), legend.getBitmapOverlay().getHeight()/2, getWidth(),legend.getBitmapOverlay().getHeight());

        canvas.drawRect(firstRect,gray_paint);
        canvas.drawRect(secondRect,blue_paint);
        legend.setBmp1_x((int) (legend.getX() + legend.getX_dir()));
        canvas.drawBitmap(legend.getBitmapOverlay() ,(int) (legend.getX() + legend.getX_dir()),legend.getBmp1_y(),null );
        invalidate();
    }
}
