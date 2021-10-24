package com.techskills.test.techskillstest.model.builder;

import com.techskills.test.techskillstest.model.Difficulty;
import com.techskills.test.techskillstest.model.QuizQuestionAnswer;

public class QuizQABuilder {
    private Long quizId;
    private String quizName;
    private Difficulty difficulty;
    private Short maxPoints;
    private String question;
    private String answer;

    public QuizQABuilder setQuizId(Long quizId) {
        this.quizId = quizId;
        return this;
    }

    public QuizQABuilder setQuizName(String quizName) {
        this.quizName = quizName;
        return this;
    }

    public QuizQABuilder setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public QuizQABuilder setMaxPoints(Short maxPoints) {
        this.maxPoints = maxPoints;
        return this;
    }

    public QuizQABuilder setQuestion(String question) {
        this.question = question;
        return this;
    }

    public QuizQABuilder setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public QuizQuestionAnswer build() {
        return new QuizQuestionAnswer(quizId, quizName, difficulty, maxPoints, question, answer);
    }
}
