package com.techskills.test.techskillstest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Quiz with quiestion that required an answer from examenee")
public class QuizQuestionAnswer extends Quiz implements Serializable {
    @ApiModelProperty(notes = "Quiz question")
    private String question;
    @ApiModelProperty(notes = "Quiz answer")
    private String answer;

    public QuizQuestionAnswer(Long quizId, String quizName,
                              Difficulty difficulty,
                              Short maxPoints,
                              String question,
                              String answer) {
        super(quizId, quizName, difficulty, maxPoints);
        this.question = question;
        this.answer = answer;
    }


}
