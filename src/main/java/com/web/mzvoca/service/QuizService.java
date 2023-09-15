package com.web.mzvoca.service;

import com.web.mzvoca.dto.QuizDTO;
import com.web.mzvoca.dto.AnswerDTO;

import java.util.List;

public interface QuizService {
    QuizDTO getQuiz(Long id);
    List<Double> checkAndCalculateWrongRates(List<AnswerDTO> userAnswers);
}
