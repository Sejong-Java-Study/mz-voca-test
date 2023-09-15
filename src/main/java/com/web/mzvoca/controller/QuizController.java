package com.web.mzvoca.controller;

import com.web.mzvoca.Member.dto.QuizDTO;
import com.web.mzvoca.dto.RequestDto;
import com.web.mzvoca.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
