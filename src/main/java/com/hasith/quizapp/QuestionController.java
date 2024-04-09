package com.hasith.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @GetMapping("allQuestions")
    public String quiz(){
        return "This Returns All Questions";
    }

}
