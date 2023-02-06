package com.example.javag;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    public List<QuestionsList> getQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Where did the first modern Summer Olympic games take place in 1896?",
                "Athens, Greece", "Roma, Italy", "Moscow, Russia", "Paris, France",
                "Athens, Greece", "");
        final QuestionsList question2 = new QuestionsList("Which boxer did Muhammad Ali fight in ‘The Rumble in the Jungle’?",
                "Tom Holland", "Tom Cruise", "George Foreman", "Lev Tolstoy",
                "George Foreman", "");
        final QuestionsList question3 = new QuestionsList("Which sport takes place in a velodrome?",
                "Hockey", "Tennis", "Formula 1", "Cycling",
                "Cycling", "");
        final QuestionsList question4 = new QuestionsList("How many points are awarded for a touchdown in American Football?",
                "45", "15", "6", "4",
                "6", "");
        final QuestionsList question5 = new QuestionsList(" Which country won the first ever football world cup?",
                "Argentina", "Uruguay", "Brazil", "France",
                "Uruguay", "");
        final QuestionsList question6 = new QuestionsList("What has Mohammed Ali’s original name?",
                "Mohammed Salah", "Cassius Clay", "Chidiegwu Chidiebele", "Ezgi Kadri",
                "Cassius Clay", "");
        final QuestionsList question7 = new QuestionsList("What is  world record time for the 100 metres?",
                "9.58 seconds", "9.48 seconds", "9.18 seconds", "10.58 seconds",
                "9.58 seconds", "");
        final QuestionsList question8 = new QuestionsList("How many gold medals has Usain Bolt won?",
                "3", "10", "9", "8",
                "8", "");
        final QuestionsList question9 = new QuestionsList("How long is the total distance of a marathon?",
                "45.195 km.", "10.000 km.", "42.195 km", "21.195 km.",
                "42.195 km", "");
        final QuestionsList question10 = new QuestionsList("How many players are there on a baseball team?",
                "9 players", "11 players", "5 players", "4 players",
                "9 players", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        return questionsLists;
    }
}


