package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnimeEasyQuestion1 extends AppCompatActivity {

    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_easy_question1);

        TextView scoreView = findViewById(R.id.aeScore1);
        score = 0;
        Score = Integer.toString(score);
        scoreView.setText(Score);
    }
    public void ClickRight(View v) {
        score+=20;
        Intent sendPlus = new Intent(this, AnimeEasyQuestion2.class);
        sendPlus.putExtra("score", score);
        startActivity(sendPlus);
        finish();
    }
    public void ClickWrong(View v) {
        Intent sendMinus = new Intent(this, AnimeEasyQuestion2.class);
        sendMinus.putExtra("score", score);
        startActivity(sendMinus);
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
        AnimeEasyQuestion1.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        AnimeEasyQuestion1.this.finish();
    }
}
