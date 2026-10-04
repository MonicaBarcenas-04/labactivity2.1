package com.example.labactivity21;

public class Question {
    private final int id;
    private final int questionResId;
    private final String correctAnswer;
    private final int detailResId;

    public Question(int id, int questionResId, String correctAnswer, int detailResId) {
        this.id = id;
        this.questionResId = questionResId;
        this.correctAnswer = correctAnswer;
        this.detailResId = detailResId;
    }

    public int getId() {
        return id;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDetailResId() {
        return detailResId;
    }
}
