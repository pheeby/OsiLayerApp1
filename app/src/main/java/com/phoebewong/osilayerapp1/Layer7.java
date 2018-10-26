package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;

public class Layer7 extends AppCompatActivity {

    ImageView frontAppLayer;
    ImageView backAppLayer;
    ImageButton homeButton;

    ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer7);

        homeButton = (ImageButton) findViewById(R.id.imageButton1);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Layer7.this, MainActivity.class));
            }
        });

        initView();

        frontAppLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backAppLayer.getVisibility() == View.VISIBLE) {
                    backAppLayer.startAnimation(sato0);
                } else {
                    frontAppLayer.startAnimation(sato0);
                }
            }
        });

        backAppLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backAppLayer.getVisibility() == View.VISIBLE) {
                    frontAppLayer.startAnimation(sato0);
                } else {
                    backAppLayer.startAnimation(sato0);
                }
            }
        });

    }

    private void showFrontAppLayer() {
        frontAppLayer.setVisibility(View.VISIBLE);
        backAppLayer.setVisibility(View.INVISIBLE);
    }

    private void showBackAppLayer() {
        frontAppLayer.setVisibility(View.INVISIBLE);
        backAppLayer.setVisibility(View.VISIBLE);
    }

    private void initView() {
        frontAppLayer = (ImageView) findViewById(R.id.imageView1);
        backAppLayer = (ImageView) findViewById(R.id.imageView2);
        showFrontAppLayer();
        sato0.setDuration(300);
        sato1.setDuration(300);

        sato0.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (frontAppLayer.getVisibility() == View.VISIBLE) {
                    frontAppLayer.setAnimation(null);
                    showBackAppLayer();
                    backAppLayer.startAnimation(sato1);
                } else {
                    backAppLayer.setAnimation(null);
                    showFrontAppLayer();
                    frontAppLayer.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}
