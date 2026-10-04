package com.example.labactivity21;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository {
    private static final List<Question> QUESTIONS = new ArrayList<>();

    static {
        QUESTIONS.add(new Question(
                0,
                R.string.question_largest,
                "JUPITER",
                R.string.detail_jupiter
        ));
        QUESTIONS.add(new Question(
                1,
                R.string.question_moons,
                "SATURN",
                R.string.detail_saturn
        ));
        QUESTIONS.add(new Question(
                2,
                R.string.question_spins,
                "URANUS",
                R.string.detail_uranus
        ));
    }

    public static List<Question> getQuestions() {
        return QUESTIONS;
    }

    public static Question getQuestion(int index) {
        if (index >= 0 && index < QUESTIONS.size()) {
            return QUESTIONS.get(index);
        }
        return QUESTIONS.get(0);
    }
}
