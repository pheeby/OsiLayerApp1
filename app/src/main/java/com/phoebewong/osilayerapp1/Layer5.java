package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;

public class Layer5 extends AppCompatActivity {

    ImageView frontSessionLayer;
    ImageView backSessionLayer;
    ImageButton homeButton;
    Button videoButton5;

    ScaleAnimation sato0 = new ScaleAnimation(1, 0, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
    ScaleAnimation sato1 = new ScaleAnimation(0, 1, 1, 1,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer5);
        homeButton = (ImageButton) findViewById(R.id.imageButton2);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Layer5.this, MainActivity.class));
          }
        });

        videoButton5 = (Button) findViewById(R.id.videoButton5);
        videoButton5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Layer5.this, PlayVideo5.class));
            }
        });

        initView();

        frontSessionLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backSessionLayer.getVisibility() == View.VISIBLE) {
                    backSessionLayer.startAnimation(sato0);
                } else {
                    frontSessionLayer.startAnimation(sato0);
                }
            }
        });

        backSessionLayer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backSessionLayer.getVisibility() == View.VISIBLE) {
                    frontSessionLayer.startAnimation(sato0);
                } else {
                    backSessionLayer.startAnimation(sato0);
                }
            }
        });

    }

    private void showFrontSessionLayer() {
        frontSessionLayer.setVisibility(View.VISIBLE);
        backSessionLayer.setVisibility(View.INVISIBLE);
    }

    private void showBackSessionLayer() {
        frontSessionLayer.setVisibility(View.INVISIBLE);
        backSessionLayer.setVisibility(View.VISIBLE);
    }

    private void initView() {
        frontSessionLayer = (ImageView) findViewById(R.id.imageView1);
        backSessionLayer = (ImageView) findViewById(R.id.imageView2);
        showFrontSessionLayer();
        sato0.setDuration(300);
        sato1.setDuration(300);

        sato0.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (frontSessionLayer.getVisibility() == View.VISIBLE) {
                    frontSessionLayer.setAnimation(null);
                    showBackSessionLayer();
                    backSessionLayer.startAnimation(sato1);
                } else {
                    backSessionLayer.setAnimation(null);
                    showFrontSessionLayer();
                    frontSessionLayer.startAnimation(sato1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}
