package com.hasith.quizapp.service;

import com.hasith.quizapp.dao.QuestionDao;
import com.hasith.quizapp.dao.QuizDao;
import com.hasith.quizapp.entities.Question;
import com.hasith.quizapp.entities.QuestionWrapper;
import com.hasith.quizapp.entities.Quiz;
import com.hasith.quizapp.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();

        List<QuestionWrapper> questionsForUSer = new ArrayList<>();

        for (Question q : questionsFromDb) {
            QuestionWrapper questionWrapper = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4());

            questionsForUSer.add(questionWrapper);
        }

        return new ResponseEntity<>(questionsForUSer, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int right = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer())) ;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
