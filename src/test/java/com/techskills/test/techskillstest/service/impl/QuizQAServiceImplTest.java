package com.techskills.test.techskillstest.service.impl;

import com.techskills.test.techskillstest.service.QuizQAService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class QuizQAServiceImplTest {

    @Test
    @DisplayName("Test should pass when it accept the correst answer to the question")
    void checkCustomerAnswer() {
        QuizQAService quizQAService = new QuizQAServiceImpl();
//        Assertions.assertTrue(quizQAService.checkCustomerAnswer(4L,"cast"));
        assertThat(quizQAService.checkCustomerAnswer(4L,"cast")).isTrue();
    }
}