package com.web.mzvoca.dto;

import lombok.Data;

@Data
public class AnswerDTO {

    private final int questionNumber; //문제 번호를 나타내는 정수형 변수
    private final double wrongCountRate; //오답률은 0과 1 사이의 값으로, 1에 가까울수록 오답률이 높다는 것을 의미합니다.

}

//AnswerDTO는 주로 문제 번호와 해당 문제의 오답률을 전송하는 데 사용