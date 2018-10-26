package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String result = Integer.toString(intent.getIntExtra(Quiz.EXTRA_SCORE, Integer.MAX_VALUE));
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(result +" out of 9");
    }

}
