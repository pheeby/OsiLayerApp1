package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;

public class Layer4 extends AppCompatActivity {

    ImageView frontTransLayer;
    ImageView backTransLayer;
    ImageButton homeButton;
    ImageButton videoButton4;

    ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer4);

        homeButton = (ImageButton) findViewById(R.id.homeImageButton4);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Layer4.this, MainActivity.class));
            }
        });

        videoButton4 = (ImageButton) findViewById(R.id.videoImageButton4);
        videoButton4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Layer4.this, PlayVideo4.class));
            }
        });

        initView();
        frontTransLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backTransLayer.getVisibility() == View.VISIBLE) {
                    backTransLayer.startAnimation(sato0);
                } else {
                    frontTransLayer.startAnimation(sato0);
                }
            }
        });

        backTransLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backTransLayer.getVisibility() == View.VISIBLE) {
                    frontTransLayer.startAnimation(sato0);
                } else {
                    backTransLayer.startAnimation(sato0);
                }
            }
        });

    }

    private void showFrontTransLayer() {
        frontTransLayer.setVisibility(View.VISIBLE);
        backTransLayer.setVisibility(View.INVISIBLE);
    }

    private void showBackTransLayer() {
        frontTransLayer.setVisibility(View.INVISIBLE);
        backTransLayer.setVisibility(View.VISIBLE);
    }

    private void initView() {
        frontTransLayer = (ImageView) findViewById(R.id.transImageView1);
        backTransLayer = (ImageView) findViewById(R.id.transImageView2);
        showFrontTransLayer();
        sato0.setDuration(300);
        sato1.setDuration(300);

        sato0.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (frontTransLayer.getVisibility() == View.VISIBLE) {
                    frontTransLayer.setAnimation(null);
                    showBackTransLayer();
                    backTransLayer.startAnimation(sato1);
                } else {
                    backTransLayer.setAnimation(null);
                    showFrontTransLayer();
                    frontTransLayer.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
