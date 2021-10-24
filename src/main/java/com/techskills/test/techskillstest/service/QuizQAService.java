package com.techskills.test.techskillstest.service;

import com.techskills.test.techskillstest.model.QuizQuestionAnswer;
import com.techskills.test.techskillstest.model.Topic;

import java.util.List;

public interface QuizQAService {

    List<QuizQuestionAnswer> getTopicQuizQuestionAnswer(Long topicId);

    QuizQuestionAnswer getQuizQA(Long quizId);

    void deleteQuizQA(Long quizId);

    QuizQuestionAnswer addQuizQA(QuizQuestionAnswer quizQA);

    QuizQuestionAnswer editQuizQA(QuizQuestionAnswer updatedQuizQA);

    boolean checkCustomerAnswer(Long quizId, String customerAnswer);

}
