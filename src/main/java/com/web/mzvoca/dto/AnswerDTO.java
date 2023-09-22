package com.web.mzvoca.dto;

import lombok.Data;

@Data
public class AnswerDTO {

    private final int questionNumber;
    private final double wrongCountRate;

}