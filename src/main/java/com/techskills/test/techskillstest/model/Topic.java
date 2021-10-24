package com.techskills.test.techskillstest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private String topicName;
    private String topicContent;
    private List<Quiz> quizzes;
}
