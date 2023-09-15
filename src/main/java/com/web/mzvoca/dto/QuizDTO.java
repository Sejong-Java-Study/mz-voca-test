package com.web.mzvoca.Member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDTO {
    private String title;
    private String content;
    private String answer; // 사용자의 답을 저장하는 필드
}
