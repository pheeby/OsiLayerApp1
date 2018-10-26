package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;
    TextView congratsTextView;
    ImageButton homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        homeButton = (ImageButton) findViewById(R.id.homeImageButton8);
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });

        //this gets the information from the previous page - score
        //and prints it on this page
        Intent intent = getIntent();
        String result = Integer.toString(intent.getIntExtra(Quiz.EXTRA_SCORE, Integer.MAX_VALUE));
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("Your score is: " + result +" out of 9");
        congratsTextView = findViewById(R.id.congTextView);
        congratsTextView.setText("Congratulations! You've finished your quiz!");


    }

}
