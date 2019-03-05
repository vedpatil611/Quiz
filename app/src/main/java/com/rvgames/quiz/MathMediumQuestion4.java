package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion4 extends AppCompatActivity {

    int score;
    String Score;
    Handler timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question4);
        timer = new Handler();
        TextView scoreView = findViewById(R.id.mmScore4);
        Intent plus = getIntent();
        int scoreVal1 = plus.getIntExtra("scoreVal", 0);
        Intent none = getIntent();
        int scoreVal2 = none.getIntExtra("scoreVal", 0);
        if(scoreVal1 > scoreVal2) {
            score = scoreVal1;
        } else {
            score = scoreVal2;
        }
        Score = Integer.toString(score);
        scoreView.setText(Score);
        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeUP();
            }
        }, 5000);
    }
    public void correctAnsw(View v) {
        score += 20;
        Intent Correct = new Intent(this, MathMediumQuestion5.class);
        Correct.putExtra("scoreVal", score);
        startActivity(Correct);
        finish();
    }
    public void incorrectAnsw(View v) {
        Intent inCorrect = new Intent(this, MathMediumQuestion5.class);
        inCorrect.putExtra("scoreVal", score);
        startActivity(inCorrect);
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitQuiz();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void exitQuiz() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion5.class));
        finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.removeCallbacksAndMessages(null);
    }
}