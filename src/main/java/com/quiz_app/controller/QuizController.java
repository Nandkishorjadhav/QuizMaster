package com.quiz_app.controller;

import com.quiz_app.dto.QuizCreateRequest;
import com.quiz_app.model.QuestionWrapper;
import com.quiz_app.model.Response;
import com.quiz_app.model.QuizResult;
import com.quiz_app.repository.QuizResultRepository;
import com.quiz_app.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizResultRepository quizResultRepository;

    @Autowired
    private QuizService quizService;

    // Save quiz result
    @PostMapping("/submit/result")
    public String saveQuizResult(@RequestBody QuizResult result) {
        quizResultRepository.save(result);
        return "Result saved successfully!";
    }

    // Create quiz using DTO
    @PostMapping("/create")
    public ResponseEntity<String> createQuizFromDTO(@RequestBody QuizCreateRequest request) {
        quizService.createQuiz(request);
        return ResponseEntity.ok("Quiz created successfully");
    }


    // Get quiz questions
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    // Submit quiz
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
