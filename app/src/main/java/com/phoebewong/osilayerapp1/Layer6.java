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

public class Layer6 extends AppCompatActivity {

    ImageView frontPresLayer;
    ImageView backPresLayer;
    ImageButton homeButton;

    ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer6);

        homeButton = (ImageButton) findViewById(R.id.imageButton1);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Layer6.this, MainActivity.class));
            }
        });

        initView();

        frontPresLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backPresLayer.getVisibility() == View.VISIBLE) {
                    backPresLayer.startAnimation(sato0);
                } else {
                    frontPresLayer.startAnimation(sato0);
                }
            }
        });

        backPresLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backPresLayer.getVisibility() == View.VISIBLE) {
                    frontPresLayer.startAnimation(sato0);
                } else {
                    backPresLayer.startAnimation(sato0);
                }
            }
        });

    }

    private void showFrontPresLayer() {
        frontPresLayer.setVisibility(View.VISIBLE);
        backPresLayer.setVisibility(View.INVISIBLE);
    }

    private void showBackPresLayer() {
        frontPresLayer.setVisibility(View.INVISIBLE);
        backPresLayer.setVisibility(View.VISIBLE);
    }

    private void initView() {
        frontPresLayer = (ImageView) findViewById(R.id.imageView1);
        backPresLayer = (ImageView) findViewById(R.id.imageView2);
        showFrontPresLayer();
        sato0.setDuration(300);
        sato1.setDuration(300);

        sato0.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (frontPresLayer.getVisibility() == View.VISIBLE) {
                    frontPresLayer.setAnimation(null);
                    showBackPresLayer();
                    backPresLayer.startAnimation(sato1);
                } else {
                    backPresLayer.setAnimation(null);
                    showFrontPresLayer();
                    frontPresLayer.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}
