package com.hasith.quizapp.dao;

import com.hasith.quizapp.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
