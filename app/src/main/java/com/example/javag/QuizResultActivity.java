package com.example.javag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javag.databinding.ActivityQuizResultBinding;

public class QuizResultActivity extends AppCompatActivity {

    ActivityQuizResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int getCorrectAnswers = getIntent().getIntExtra("correct",0);
        final int getInCorrectAnswers = getIntent().getIntExtra("incorrect",0);

        binding.correctAnswer.setText(String.valueOf(("Correct answers - " + getCorrectAnswers)));
        binding.inCorrectAnswer.setText(String.valueOf(("Incorrect answers - " + getInCorrectAnswers)));

        binding.startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuizResultActivity.this,MainActivity.class));
        finish();
    }
}