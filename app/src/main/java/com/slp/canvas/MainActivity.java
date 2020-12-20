package com.slp.canvas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Boolean open;
    Button main;
    Button popupClose;
    LegendLayout legendLayout;
    ConstraintLayout legend_layout_container;
    ConstraintLayout main_layout;
    AlertDialog dialog;
    AlertDialog.Builder dialoBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open = true;
        main = findViewById(R.id.main);

        legend_layout_container = findViewById(R.id.legend_layout);
        legendLayout = new LegendLayout(this);
        legend_layout_container.addView(legendLayout);


        main.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View view) {

                createPopup();


            }
        });
        legend_layout_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(open) {
                    open = ! open;
                    ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationX", legendLayout.getWidth() - 100);
                    animation.setDuration(2000);
                    animation.start();
                } else {
                    open = ! open;
                    ObjectAnimator animation = ObjectAnimator.ofFloat(view, "translationX", 100);
                    animation.setDuration(2000);
                    animation.start();
                }

            }
        });

    }

    public void createPopup() {
        dialoBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.popup, null);
        popupClose = popup.findViewById(R.id.popup_close);
        dialoBuilder.setView(popup);
        dialog = dialoBuilder.create();
        dialog.show();
        popupClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

}
