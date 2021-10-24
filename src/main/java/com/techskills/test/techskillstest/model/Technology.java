package com.techskills.test.techskillstest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {
    private String technologyName;
    private String technologyDescription;
    private List<Topic> technologyTopics;
}
