package com.web.mzvoca.service;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.dto.QuizDTO;
import com.web.mzvoca.repository.QuestionRepository;
import com.web.mzvoca.repository.TotalCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final TotalCountRepository totalCountRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<AnswerDTO> getWrongCountRate() {

        return null;
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