package com.web.mzvoca.controller;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import com.web.mzvoca.dto.RequestDto;
import com.web.mzvoca.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
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

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @PostMapping("/api/wrongRate")
    @ResponseBody
    public QuizDTO getWrongRate(@RequestBody List<RequestDto> list) {
        System.out.println(list);
        return new QuizDTO("1번", "내용 없음", "정답");
    }

}
