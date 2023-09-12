package com.web.mzvoca.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static com.web.mzvoca.repository.DBConst.*;
import static org.assertj.core.api.Assertions.*;

class QuestionRepositoryImplTest {

    QuestionRepository questionRepository;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        questionRepository = new QuestionRepositoryImpl(dataSource);
    }


    @Test
    @DisplayName("특정 문항의 오류 횟수 읽기")
    void questionWrongCountRead() {
        //given
        int questionNumber = 1;
        Integer result = null;

        //when
        result = questionRepository.questionWrongCountRead(questionNumber);

        //then
        assertThat(result).isEqualTo(3);
//        assertThatThrownBy(() -> questionRepository.questionWrongCountRead(questionNumber + 3))
//                .isInstanceOf(NoSuchElementException.class);

    }

    @Test
    @DisplayName("특정 문항의 오답 횟수 1 증가")
    void questionWrongCountUpdate() {
        //given
        int questionNumber = 1;
        Integer beforeResult = questionRepository.questionWrongCountRead(questionNumber);

        //when
        questionRepository.questionWrongCountUpdate(questionNumber);
        Integer afterResult = questionRepository.questionWrongCountRead(questionNumber);

        //then
        assertThat(afterResult).isEqualTo(beforeResult + 1);

    }
}