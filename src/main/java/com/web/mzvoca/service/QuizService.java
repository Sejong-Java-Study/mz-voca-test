package com.web.mzvoca.service;

import com.web.mzvoca.dto.AnswerDTO;
import com.web.mzvoca.dto.RequestDto;
import java.util.List;

public interface QuizService {
    List<AnswerDTO> getWrongCountRate(List<RequestDto> requestDtos);
}
//매개변수: List<RequestDto> requestDtos - 사용자의 답변과 관련된 정보를 포함하는 RequestDto 객체의 목록
//반환 타입: List<AnswerDTO> - 각 문제에 대한 잘못된 답변 비율을 포함하는 AnswerDTO 객체의 목록
