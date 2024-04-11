package com.hasith.quizapp.service;

import com.hasith.quizapp.dao.QuestionDao;
import com.hasith.quizapp.dao.QuizDao;
import com.hasith.quizapp.entities.Question;
import com.hasith.quizapp.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    QuizDao quizDao;
    QuestionDao questionDao;

    @Autowired
    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }
}
