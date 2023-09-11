package com.web.mzvoca.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final DataSource dataSource;

    /**
     * @return 특정 문항의 "wrong_count"를 반환
     */
    @Override
    public int questionWrongCountRead(int questionNumber) {
//        String sql = "// wrong_count 컬럼 조회 - where PK 값으로";
        String sql = "select wrong_count from question where question_number = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Datasource로부터 커넥션을 가져온 뒤, 쿼리문을 실행하여 ResultSet에 반환
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, questionNumber);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("wrong_count");
            } else {
                throw new NoSuchElementException("wrong_count 값이 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, rs);
        }
    }

    @Override
    public void questionWrongCountUpdate() {

    }

    private Connection getConnection() throws SQLException {
        // 트랜잭션 동기화를 위해 DataSourceUtils 메서드 사용
        Connection con = DataSourceUtils.getConnection(dataSource);
        return con;
    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        // 트랜잭션 동기화를 위해 DataSourceUtils 메서드 사용
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}
