package com.quiz_app.service;

import com.quiz_app.dto.QuestionDTO;
import com.quiz_app.dto.QuizCreateRequest;
import com.quiz_app.model.Question;
import com.quiz_app.model.QuestionWrapper;
import com.quiz_app.model.Quiz;
import com.quiz_app.model.Response;
import com.quiz_app.repository.QuestionRepository;
import com.quiz_app.repository.QuizRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public void createQuiz(QuizCreateRequest request) {
        Quiz quiz = new Quiz();
        quiz.setTitle(request.getTitle());
        quiz.setCategory(request.getCategory());
        quizRepository.save(quiz);

        List<Question> questionList = new ArrayList<>();

        for (QuestionDTO q : request.getQuestions()) {
            Question question = new Question();
            question.setQuiz(quiz);
            question.setQuestionTitle(q.getQuestionTitle());
            question.setOption1(q.getOption1());
            question.setOption2(q.getOption2());
            question.setOption3(q.getOption3());
            question.setOption4(q.getOption4());
            question.setRightAnswer(q.getRightAnswer());
            question.setDifficultyLevel(q.getDifficultyLevel() != null ? q.getDifficultyLevel() : "medium");
            question.setCategory(request.getCategory());

            questionList.add(question);
        }

        questionRepository.saveAll(questionList);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id: " + quizId));

        List<QuestionWrapper> wrappers = new ArrayList<>();

        for (Question q : quiz.getQuestions()) {
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            wrappers.add(qw);
        }

        return ResponseEntity.ok(wrappers);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer quizId, List<Response> responses) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id: " + quizId));

        List<Question> questions = quiz.getQuestions();
        int score = 0;

        for (int i = 0; i < responses.size(); i++) {
            Question q = questions.get(i);
            Response r = responses.get(i);
            if (q.getRightAnswer().equalsIgnoreCase(r.getAnswer())) {
                score++;
            }
        }

        return ResponseEntity.ok(score);
    }
}
