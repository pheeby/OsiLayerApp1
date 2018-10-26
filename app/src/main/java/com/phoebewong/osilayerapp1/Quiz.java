package com.phoebewong.osilayerapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Quiz extends AppCompatActivity {

    private QuestionLibrary questionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText() == mAnswer) {

                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText() == mAnswer) {

                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText() == mAnswer) {

                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText() == mAnswer) {

                    mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();

                    updateQuestion();
                }
            }
        });
    }


    private void updateQuestion() {
        mQuestionView.setText(questionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(questionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(questionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(questionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(questionLibrary.getChoice4(mQuestionNumber));
        mAnswer = questionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        if (mQuestionNumber > 8) {
            Intent resultIntent = new Intent(this, ResultActivity.class);
            resultIntent.putExtra("SCORE", mScore);
            startActivity(resultIntent);
        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }
}

