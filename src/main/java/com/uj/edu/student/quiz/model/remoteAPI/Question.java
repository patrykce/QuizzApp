package com.uj.edu.student.quiz.model.remoteAPI;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private float id;
    private String question;
    private String description;
    private Answers answers;
    private String multiple_correct_answers;
    private CorrectAnswers correct_answers;
    private String correct_answer;
    private String explanation;
    private String tip;
    private List<Tag> tags;
    private String category;
    private String difficulty;
}