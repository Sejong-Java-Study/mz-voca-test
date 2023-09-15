package com.web.mzvoca.Member.service;

import com.web.mzvoca.Member.dto.QuizDTO;

public interface QuizService {
    QuizDTO getQuiz(Long id);
    boolean checkAnswer(QuizDTO quizDTO);
}
//퀴즈 인터페이스
