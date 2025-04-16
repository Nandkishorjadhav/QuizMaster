package com.quiz_app.service;

import com.quiz_app.dto.QuizCreateRequest;
import com.quiz_app.model.QuestionWrapper;
import com.quiz_app.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    void createQuiz(QuizCreateRequest request);
    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId);
    ResponseEntity<Integer> calculateResult(Integer quizId, List<Response> responses);
}
