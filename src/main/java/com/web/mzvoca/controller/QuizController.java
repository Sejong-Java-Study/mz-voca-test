package com.web.mzvoca.controller;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/{id}")
    public QuizDTO getQuiz(@PathVariable Long id) {
        return quizService.getQuiz(id);

    @PostMapping("/checkAnswers")
    public List<Double> checkAndCalculateWrongRates(@RequestBody List<UserAnswerDTO> userAnswers) {
        return quizService.checkAndCalculateWrongRates(userAnswers);
    }
    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody List<QuizDTO> quizDTOs) {
        quizService.processQuizAnswers(quizDTOs);
        return ResponseEntity.ok("Quiz processed successfully");
    }
}
