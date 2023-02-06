package com.example.javag;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.javag.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initBank();

        binding.option1.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option1.getText().toString();
                binding.option1.setBackgroundColor(Color.RED);
                binding.option1.setTextColor(Color.WHITE);

                revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });

        binding.option2.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option2.getText().toString();
                binding.option2.setBackgroundColor(Color.RED);
                binding.option2.setTextColor(Color.WHITE);

                revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });

        binding.option3.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option3.getText().toString();
                binding.option3.setBackgroundColor(Color.RED);
                binding.option3.setTextColor(Color.WHITE);

                revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });

        binding.option4.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.option4.getText().toString();
                binding.option4.setBackgroundColor(Color.RED);
                binding.option4.setTextColor(Color.WHITE);

                revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
            }
        });
        binding.nextBtn.setOnClickListener(v -> {
            if (selectedOptionByUser.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please select", Toast.LENGTH_SHORT).show();
            } else {
                changeNextQuestions();
            }
        });
    }

    private int getCorrectAnswer() {
        int correctAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswer() {
        int correctInAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctInAnswers++;
            }
        }
        return correctInAnswers;
    }

    @SuppressLint("SetTextI18n")
    private void initBank() {
        QuestionsBank questionsBank = new QuestionsBank();
        questionsLists = questionsBank.getQuestions();
        binding.questions.setText((currentQuestionPosition + 1) + "/" + questionsLists.size());
        binding.question.setText(questionsLists.get(0).getQuestion());
        binding.option1.setText(questionsLists.get(0).getOption1());
        binding.option2.setText(questionsLists.get(0).getOption2());
        binding.option3.setText(questionsLists.get(0).getOption3());
        binding.option4.setText(questionsLists.get(0).getOption4());
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getMove() {
        Intent intent = new Intent(MainActivity.this, QuizResultActivity.class);
        intent.putExtra("correct", getCorrectAnswer());
        intent.putExtra("incorrect", getInCorrectAnswer());
        startActivity(intent);
        finish();
    }

    private void revealAnswer() {
        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if (binding.option1.getText().toString().equals(getAnswer)) {
            binding.option1.setBackgroundColor(Color.GREEN);
            binding.option1.setTextColor(Color.WHITE);
        } else if (binding.option2.getText().toString().equals(getAnswer)) {
            binding.option2.setBackgroundColor(Color.GREEN);
            binding.option2.setTextColor(Color.WHITE);
        } else if (binding.option3.getText().toString().equals(getAnswer)) {
            binding.option3.setBackgroundColor(Color.GREEN);
            binding.option3.setTextColor(Color.WHITE);
        } else if (binding.option4.getText().toString().equals(getAnswer)) {
            binding.option4.setBackgroundColor(Color.GREEN);
            binding.option4.setTextColor(Color.WHITE);
        }
    }

    @SuppressLint("SetTextI18n")
    private void changeNextQuestions() {
        currentQuestionPosition++;

        if ((currentQuestionPosition + 1) == questionsLists.size()) {
            binding.nextBtn.setText("Done");
        }
        if (currentQuestionPosition < questionsLists.size()) {
            selectedOptionByUser = "";
            binding.option1.setBackgroundResource(R.drawable.round_back_white_stroke);
            binding.option1.setTextColor(Color.parseColor("#1F6BB8"));

            binding.option2.setBackgroundResource(R.drawable.round_back_white_stroke);
            binding.option2.setTextColor(Color.parseColor("#1F6BB8"));

            binding.option3.setBackgroundResource(R.drawable.round_back_white_stroke);
            binding.option3.setTextColor(Color.parseColor("#1F6BB8"));

            binding.option4.setBackgroundResource(R.drawable.round_back_white_stroke);
            binding.option4.setTextColor(Color.parseColor("#1F6BB8"));

            binding.questions.setText((currentQuestionPosition + 1) + "/" + questionsLists.size());
            binding.question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            binding.option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            binding.option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            binding.option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            binding.option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        } else {
            getMove();
        }
    }
}