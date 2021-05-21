package com.uj.edu.student.quiz.controller;

import com.uj.edu.student.quiz.model.remoteAPI.Question;
import com.uj.edu.student.quiz.service.QuestionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/questions/")
public class QuestionController {
    private final QuestionsService questionsService;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/all")
    public ResponseEntity<Question[]> getAllCommentsForPost() {
        Question[] mono = questionsService.getLinuxQuestions();

        System.out.println(Arrays.toString(mono));
        return status(OK)
                .body(mono);
    }

    @GetMapping("/all/{limit}/{difficulty}/{tags}")
    public ResponseEntity<Question[]> getGenericQuestions(@PathVariable("limit") int limit, @PathVariable("difficulty") String d) {
        Question[] mono = questionsService.getLinuxQuestions();

        return status(OK)
                .body(mono);
    }

}
