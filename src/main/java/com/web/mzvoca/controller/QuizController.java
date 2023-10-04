package com.web.mzvoca.controller;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.dto.RequestDto;
import com.web.mzvoca.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/wrongRate")
    public List<AnswerDTO> getWrongRate(@RequestBody List<RequestDto> requestDtos) {
        return quizService.getWrongCountRate(requestDtos);
    }
}
