package com.slp.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class Legend extends View {

    Bitmap bmp1;
    Bitmap bmp2;
    Bitmap overlay;
    Canvas canvas;


    int x_dir;
    int bmp1_x, bmp1_y;


    public Legend(Context context) {
        super(context);
        bmp1_x = 0;
        bmp1_y = 0;
        x_dir = 1;
        bmp1 = BitmapFactory.decodeResource(getResources(),R.drawable.imag_one);
        bmp2 = BitmapFactory.decodeResource(getResources(),R.drawable.arrow);
        overlay = overlayBitmapToCenter(bmp1,bmp2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(overlay, bmp1_x  ,bmp1_y,null);

    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        params.width = 400;
        params.height = 400;
        super.setLayoutParams(params);
    }

    private Bitmap overlay(Bitmap bmp1, Bitmap bmp2) {
        Bitmap bmOverlay = Bitmap.createBitmap(bmp1.getWidth(), bmp1.getHeight(), bmp1.getConfig());
        canvas = new Canvas(bmOverlay);
        canvas.drawBitmap(bmp1, new Matrix(), null);
        canvas.drawBitmap(bmp2, new Matrix(), null);
        return bmOverlay;
    }

    public static Bitmap overlayBitmapToCenter(Bitmap bitmap1, Bitmap bitmap2) {
        int bitmap1Width = bitmap1.getWidth();
        int bitmap1Height = bitmap1.getHeight();
        int bitmap2Width = bitmap2.getWidth();
        int bitmap2Height = bitmap2.getHeight();

        float marginLeft = (float) 0;
        float marginTop = (float) (bitmap1Height * 0.5 - bitmap2Height * 0.5);

        Bitmap overlayBitmap = Bitmap.createBitmap(bitmap1Width, bitmap1Height, bitmap1.getConfig());
        Canvas canvas = new Canvas(overlayBitmap);
        canvas.drawBitmap(bitmap1, new Matrix(), null);
        canvas.drawBitmap(bitmap2, marginLeft, marginTop, null);

        return overlayBitmap;
    }

    public Bitmap getBitmapOverlay() {
        return this.overlay;
    }


    public int getX_dir() {
        return x_dir;
    }

    public void setX_dir(int x_dir) {
        this.x_dir = x_dir;
    }

    public int getBmp1_x() {
        return bmp1_x;
    }

    public void setBmp1_x(int bmp1_x) {
        this.bmp1_x = bmp1_x;
    }

    public int getBmp1_y() {
        return bmp1_y;
    }

    public void setBmp1_y(int bmp1_y) {
        this.bmp1_y = bmp1_y;
    }
}
