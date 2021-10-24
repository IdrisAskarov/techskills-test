package com.techskills.test.techskillstest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Quiz  implements Serializable {
    private Long quizId;
    private String quizName;
    private Difficulty difficulty;
    private Short maxPoints;
}
