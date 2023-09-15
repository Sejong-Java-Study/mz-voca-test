package com.web.mzvoca.service;

import com.web.mzvoca.dto.QuizDTO;
import com.web.mzvoca.repository.QuestionRepository;
import com.web.mzvoca.repository.TotalCountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private TotalCountRepository totalCountRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public double processQuizAnswers(List<com.web.mzvoca.dto.QuizDTO> quizDTOs) {
        // 전체 제출 횟수 업데이트
        totalCountRepository.totalCountUpdate();

        for (QuizDTO quizDTO : quizDTOs) {
            // tf가 false인 경우 해당 문제의 오답 횟수 업데이트
            if (!quizDTO.isTf()) {
                questionRepository.questionWrongCountUpdate(quizDTO.getQuestionNumber());
            }
        }
        // 전체 제출 횟수 가져오기
        double totalSubmitCount = totalCountRepository.totalCountRead();

        double questionWrongCount = questionRepository.questionWrongCountRead(quizDTOs.get(0).getQuestionNumber());

        // 오답률 계산 후 반환
        return (questionWrongCount / totalSubmitCount * 100);
    }
}

/**
 * 0. totalCountReposiotory.totalCountUpdate() 호출
 * 1. tf가 false면 questionRepository.questionWrongCountUpdate(문제 번호) 호출
 * 2. 오답률 반환
 * 2-1. totalCountReposiotory.totalCountRead() 호출 : 전체 제출 횟수 값 가져오기
 * 2-2. questionRepository.questionWrongCountRead(문제번호) 호출 : 특정 문제의 오답 횟수 값 가져오기
 * 2-3. (오답 횟수 값 / 전체 제출 횟수 값) 반환
 *
 */