package com.web.mzvoca.repository;

public interface QuestionRepository {

    public int questionWrongCountRead(int questionNumber);

    public void questionWrongCountUpdate();
}
