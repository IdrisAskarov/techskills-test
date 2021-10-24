package com.techskills.test.techskillstest.service.impl;

import com.techskills.test.techskillstest.model.Difficulty;
import com.techskills.test.techskillstest.model.QuizQuestionAnswer;
import com.techskills.test.techskillstest.model.Topic;
import com.techskills.test.techskillstest.model.builder.QuizQABuilder;
import com.techskills.test.techskillstest.service.QuizQAService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class QuizQAServiceImpl implements QuizQAService {
    Map<Long, QuizQuestionAnswer> quizQAMap = new ConcurrentHashMap<>();

    {
        System.out.println("some init");
        quizQAMap.put(1L, new QuizQABuilder()
                .setQuizId(1L)
                .setQuizName("primitive types")
                .setDifficulty(Difficulty.BEGINNER)
                .setMaxPoints((short) 1)
                .setQuestion("What is the length of type int?")
                .setAnswer("32")
                .build());
        quizQAMap.put(2L, new QuizQABuilder()
                .setQuizId(2L)
                .setQuizName("primitive types")
                .setDifficulty(Difficulty.BEGINNER)
                .setMaxPoints((short) 1)
                .setQuestion("How many primitive types of type integer exist in java")
                .setAnswer("4")
                .build());
        quizQAMap.put(3L, new QuizQABuilder()
                .setQuizId(3L)
                .setQuizName("primitive types")
                .setDifficulty(Difficulty.BEGINNER)
                .setMaxPoints((short) 1)
                .setQuestion("Would you like some sex?")
                .setAnswer("Yes")
                .build());
        quizQAMap.put(4L, new QuizQABuilder()
                .setQuizId(4L)
                .setQuizName("primitive types")
                .setDifficulty(Difficulty.BEGINNER)
                .setMaxPoints((short) 1)
                .setQuestion("What should we do when we try to assign value int to variable of type short?")
                .setAnswer("cast")
                .build());
    }

    @Override
    public List<QuizQuestionAnswer> getTopicQuizQuestionAnswer(Long topicId) {
        return quizQAMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public QuizQuestionAnswer getQuizQA(Long quizId) {
        return quizQAMap.get(quizId);
    }

    @Override
    public void deleteQuizQA(Long quizId) {
        quizQAMap.remove(quizId);
    }

    @Override
    public QuizQuestionAnswer addQuizQA(QuizQuestionAnswer quizQA) {
        long leftLimit = quizQAMap.size() + 1;
        long rightLimit = 10000000l;
        Long id = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        quizQA.setQuizId(id);
        return quizQAMap.put(id, quizQA);
    }

    @Override
    public QuizQuestionAnswer editQuizQA(QuizQuestionAnswer updatedQuizQA) {
        quizQAMap.put(updatedQuizQA.getQuizId(), updatedQuizQA);
        return updatedQuizQA;
    }

    @Override
    public boolean checkCustomerAnswer(Long quizId, String customerAnswer) {
        QuizQuestionAnswer quizQA = quizQAMap.get(quizId);
        customerAnswer = customerAnswer.replaceAll("\\s", "").toLowerCase();
        String questionAnswer = quizQA.getAnswer().replaceAll("\\s","").toLowerCase();
        return customerAnswer.equals(questionAnswer);
    }
}
