package com.web.mzvoca.dto;

import lombok.Data;

@Data
public class RequestDto {
    private int questionNumber; //문제 번호를 나타내는 정수 필드
    private int selectedAnswer; //선택된 답변의 번호나 값을 나타내는 정수 필드
    private boolean tf; // 참/거짓 값을 나타내는 불린 필드
    private int section; //섹션 번호나 구분을 나타내는 정수 필드
}
//RequestDto는 클라이언트에서 서버로 보내는 요청 데이터의 구조를 정의