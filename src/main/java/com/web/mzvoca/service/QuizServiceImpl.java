package com.web.mzvoca.service;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.dto.RequestDto;
import com.web.mzvoca.repository.QuestionRepository;
import com.web.mzvoca.repository.TotalCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final TotalCountRepository totalCountRepository;
    private final QuestionRepository questionRepository;

    @Override
    public List<AnswerDTO> getWrongCountRate(List<RequestDto> requestDtos) {
        int totalCount = totalCountRepository.totalCountRead();//전체 제출 횟수를 조회합니다.
        List<AnswerDTO> answerDTOList = new ArrayList<>();
//사용자의 답변을 기반으로 각 문제의 잘못된 답변 비율을 계산
        for (RequestDto requestDto : requestDtos) {
            int questionNumber = requestDto.getQuestionNumber();
            int wrongCount = questionRepository.questionWrongCountRead(questionNumber);
            //사용자의 답변 목록을 순회하면서 각 문제의 잘못된 답변 횟수를 조회합니다.
            double wrongRate = (double) wrongCount / totalCount;
            answerDTOList.add(new AnswerDTO(questionNumber, wrongRate));
        }
        //잘못된 답변 비율을 계산하고, 이를 AnswerDTO 객체에 저장합니다.
        //계산된 AnswerDTO 객체를 목록에 추가합니다.

        return answerDTOList;
        //반환 값: 각 문제에 대한 잘못된 답변 비율을 포함하는 AnswerDTO 객체의 목록
    }
}
