package com.web.mzvoca.Member.service;

import com.web.mzvoca.Member.dto.QuizDTO;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Override
    public QuizDTO getQuiz(Long id) {
        // DB에서 id에 해당하는 문제를 가져와서 반환
        return new QuizDTO("Sample Title", "Sample Content", null);
    }

    @Override
    public boolean checkAnswer(QuizDTO quizDTO) {
        // DB에서 정답을 가져와서 quizDTO의 answer와 비교
        String correctAnswer = "Sample Answer"; // DB에서 가져온 정답
        return correctAnswer.equals(quizDTO.getAnswer());
    }
}
//퀴즈 서비스 구현 클래스