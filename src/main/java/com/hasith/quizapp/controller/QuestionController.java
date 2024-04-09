package com.hasith.quizapp.controller;

import com.hasith.quizapp.entities.Question;
import com.hasith.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("allQuestions")
    public List<Question> quiz(){
        return questionService.getAllQuestions();
    }

}
