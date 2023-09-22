package com.web.mzvoca.service;

import com.web.mzvoca.dto.QuizDTO;
import com.web.mzvoca.dto.AnswerDTO;

import java.util.List;

public interface QuizService {

    // List<AnswerDTO>를 반환
    List<AnswerDTO> getWrongCountRate();
}
