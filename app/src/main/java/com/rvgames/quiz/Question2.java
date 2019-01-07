package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class Question2 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        Intent ClickTrue = getIntent();
        int scoreVal1 = ClickTrue.getIntExtra("scoreValue",0);
        Intent ClickFalse = getIntent();
        int scoreVal2 = ClickFalse.getIntExtra("scoreValue",0);
        TextView scoreValue = findViewById(R.id.textView6);
        if (scoreVal1 < scoreVal2) {
            score = scoreVal2;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreVal1;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }
    public void opt1(View op1) {
        Intent Opt1 = new Intent(this, MEQuestion3.class);
        Opt1.putExtra("scoreVal", score);
        startActivity(Opt1);
        finish();
    }
    public void opt2(View op2) {
        Intent Opt2 = new Intent(this, MEQuestion3.class);
        score = score + 1;
        Opt2.putExtra("scoreVal", score);
        startActivity(Opt2);
        finish();
    }
    public void opt3(View op3) {
        Intent Opt3 = new Intent(this, MEQuestion3.class);
        Opt3.putExtra("scoreVal", score);
        startActivity(Opt3);
        finish();
    }
    public void opt4(View op4) {
        Intent Opt4 = new Intent(this, MEQuestion3.class);
        Opt4.putExtra("scoreVal", score);
        startActivity(Opt4);
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        exitQuiz();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void exitQuiz() {
        Question2.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        Question2.this.finish();
    }
}
