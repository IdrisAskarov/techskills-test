package com.techskills.test.techskillstest.controller;

import com.techskills.test.techskillstest.model.QuizQuestionAnswer;
import com.techskills.test.techskillstest.model.Topic;
import com.techskills.test.techskillstest.service.QuizQAService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz/qa")
@RequiredArgsConstructor
public class QuizQAController {

    private final QuizQAService quizQAService;

    @GetMapping("/topic/{topicId}")
    public List<QuizQuestionAnswer> getTopicQuizQA(@PathVariable Long topicId) {
        return quizQAService.getTopicQuizQuestionAnswer(topicId);
    }

    @GetMapping("/{quizId}")
    public QuizQuestionAnswer getQuizQA(@PathVariable Long quizId) {
        return quizQAService.getQuizQA(quizId);
    }

    @PostMapping("/")
    public QuizQuestionAnswer addQuizQA(@RequestBody QuizQuestionAnswer quizQuestionAnswer) {
        return quizQAService.addQuizQA(quizQuestionAnswer);
    }

    @PutMapping("/")
    public QuizQuestionAnswer updateQuizQA(@RequestBody QuizQuestionAnswer quizQuestionAnswer) {
        return quizQAService.editQuizQA(quizQuestionAnswer);
    }

    @DeleteMapping("/{quizId}")
    public void deleteQuizQA(@PathVariable Long quizId) {
        quizQAService.deleteQuizQA(quizId);
    }

    @GetMapping("/check/{quizId}")
    @ApiOperation(value = "Checks an examinee's answer correctness",
            notes = "Checks if an examinee answered correctly the given quiz question ",
            response = Boolean.class)
    public boolean checkCustomerAnswer(@ApiParam(value = "Quiz Id by which the answer must be checked",required = true) @PathVariable Long quizId,
                                       @ApiParam(value = "The answer given by examinee to the question") @RequestParam("answer") String answer) {
        return quizQAService.checkCustomerAnswer(quizId, answer);
    }
}
