package com.web.mzvoca.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.web.mzvoca.repository.DBConst.*;
import static org.assertj.core.api.Assertions.*;

@Slf4j
class totalCountRepositoryImplTest {

    TotalCountRepository totalCountRepository;

    @BeforeEach
    void beforeEach() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        totalCountRepository = new TotalCountRepositoryImpl(dataSource);
    }

    @Test
    @DisplayName("총 제출 횟수 읽기")
    void totalCountRead() {
        //given
        Integer result = null;

        //when
//        assertThatThrownBy(() -> totalCountRepository.totalCountRead())
//                .isInstanceOf(NoSuchElementException.class);
        result = totalCountRepository.totalCountRead();

        //then
        assertThat(result).isEqualTo(3);

    }
}