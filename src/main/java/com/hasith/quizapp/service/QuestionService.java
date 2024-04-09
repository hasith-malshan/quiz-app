package com.hasith.quizapp.service;

import com.hasith.quizapp.dao.QuestionDao;
import com.hasith.quizapp.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    private QuestionDao questionDao;
    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
    public List<Question> findByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public void addQuestion(Question question){
        questionDao.save(question);
    }
}
