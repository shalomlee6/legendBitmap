package com.slp.canvas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    Boolean open;
    LegendLayout legendLayout;
    ConstraintLayout legend_layout_container;
    ConstraintLayout main_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open = true;
        legend_layout_container = findViewById(R.id.legend_layout);
        legendLayout = new LegendLayout(this);
        legend_layout_container = findViewById(R.id.legend_layout);
        legend_layout_container.addView(legendLayout);

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



}
