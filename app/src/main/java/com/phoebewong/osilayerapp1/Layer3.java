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

public class Layer3 extends AppCompatActivity {

    ImageView frontNetworkLayer;
    ImageView backNetworkLayer;
    ImageButton homeButton;
    ImageButton videoButton3;

    ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer3);

        homeButton = (ImageButton) findViewById(R.id.homeImageButton3);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Layer3.this, MainActivity.class));
            }
        });

        videoButton3 = (ImageButton) findViewById(R.id.videoImageButton3);
        videoButton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Layer3.this, PlayVideo3.class));
            }
        });

        initView();

        frontNetworkLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backNetworkLayer.getVisibility() == View.VISIBLE) {
                    backNetworkLayer.startAnimation(sato0);
                } else {
                    frontNetworkLayer.startAnimation(sato0);
                }
            }
        });

        backNetworkLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backNetworkLayer.getVisibility() == View.VISIBLE) {
                    frontNetworkLayer.startAnimation(sato0);
                } else {
                    backNetworkLayer.startAnimation(sato0);
                }
            }
        });

    }

    private void showFrontNetworkLayer() {
        frontNetworkLayer.setVisibility(View.VISIBLE);
        backNetworkLayer.setVisibility(View.INVISIBLE);
    }

    private void showBackNetworkLayer() {
        frontNetworkLayer.setVisibility(View.INVISIBLE);
        backNetworkLayer.setVisibility(View.VISIBLE);
    }

    private void initView() {
        frontNetworkLayer = (ImageView) findViewById(R.id.netImageView1);
        backNetworkLayer = (ImageView) findViewById(R.id.netImageView2);
        showFrontNetworkLayer();
        sato0.setDuration(300);
        sato1.setDuration(300);

        sato0.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (frontNetworkLayer.getVisibility() == View.VISIBLE) {
                    frontNetworkLayer.setAnimation(null);
                    showBackNetworkLayer();
                    backNetworkLayer.startAnimation(sato1);
                } else {
                    backNetworkLayer.setAnimation(null);
                    showFrontNetworkLayer();
                    frontNetworkLayer.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
