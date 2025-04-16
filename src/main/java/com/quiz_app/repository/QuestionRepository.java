package com.quiz_app.repository;

import com.quiz_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    // Fetch questions by category
    List<Question> findByCategory(String category);

    // Fetch questions by difficulty level
    List<Question> findByDifficultyLevel(String difficultyLevel);

    // Custom method to fetch by category and difficulty
    List<Question> findByCategoryAndDifficultyLevel(String category, String difficultyLevel);
}
