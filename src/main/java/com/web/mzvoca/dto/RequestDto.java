package com.web.mzvoca.dto;

import lombok.Data;

@Data
public class RequestDto {
    private int questionNumber;
    private int selectedAnswer;
    private boolean tf;
    private int section;
}
