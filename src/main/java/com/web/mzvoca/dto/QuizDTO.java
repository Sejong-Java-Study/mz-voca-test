package com.web.mzvoca.dto;

import lombok.Data;

@Data
public class QuizDTO {
    private Long questionNumber; //문제 번호를 나타내는 Long 타입의 변수
    private String q; //  문제 내용을 나타내는 문자열
    private AnswerOption[] a; // 답안 옵션을 나타내는 AnswerOption 배열입니다.
    private String c; // : 문제에 대한 해설을 나타내는 문자열입니다.

    @Data
    public static class AnswerOption {
        private String answer; //답안의 내용을 나타내는 문자열입니다.
        private int[] type; // 답안의 유형을 나타내는 정수 배열
    }
}

//QuizDTO는 주로 퀴즈 문제의 내용, 답안 옵션, 해설 등의 정보를 전송하는 데 사용
