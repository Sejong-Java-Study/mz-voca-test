package com.web.mzvoca.Member.controller;

import com.web.mzvoca.Member.dto.QuizDTO;
import com.web.mzvoca.Member.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    //값 가져오기

    @GetMapping("/quiz/{id}")
    public QuizDTO getQuiz(@PathVariable Long id) {
        return quizService.getQuiz(id);
    }

    //값 보여주기
    @PostMapping("/quiz/submit")
    public String submitAnswer(@RequestBody QuizDTO quizDTO) {
        boolean isCorrect = quizService.checkAnswer(quizDTO);
        return isCorrect ? "Correct Answer!" : "Wrong Answer!";
    }


}
