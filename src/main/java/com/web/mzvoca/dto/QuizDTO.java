package com.web.mzvoca.dto;

public class QuizDTO {
    private Long questionNumber;
    private boolean tf;
    private Long id;
    private String question;
    private String answer;
    private Double wrongRate; // 오답률

    // 기본 생성자
    public QuizDTO() {}

    // 모든 필드를 포함하는 생성자
    public QuizDTO(Long id, String question, String answer, Double wrongRate) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.wrongRate = wrongRate;
    }

    // getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getWrongRate() {
        return wrongRate;
    }

    public void setWrongRate(Double wrongRate) {
        this.wrongRate = wrongRate;
    }

    public boolean isTf() {
        return tf;
    }

    public Long getQuestionNumber() {
        return questionNumber;
    }

}
