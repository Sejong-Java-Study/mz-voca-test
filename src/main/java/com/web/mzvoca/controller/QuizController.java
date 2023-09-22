package com.web.mzvoca.controller;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.dto.QuizDTO;
import com.web.mzvoca.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import com.web.mzvoca.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;


    @PostMapping("/api/wrongRate")
    @ResponseBody
    public List<AnswerDTO> getWrongRate(@RequestBody List<RequestDto> list) {
        /**
         * 1. 문제의 오답률 반환
         */
        System.out.println(list);
        return null;
    }

}
