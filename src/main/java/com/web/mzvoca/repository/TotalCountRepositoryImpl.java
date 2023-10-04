package com.web.mzvoca.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TotalCountRepositoryImpl implements TotalCountRepository {

    private final DataSource dataSource;

    /**
     * @return 현재 제출된 횟수를 반환
     */
    @Override
    public int totalCountRead() {
        String sql = "select * from totalcount";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 가져온 데이터가 있을 때 실행할 부분
                int totalCount = rs.getInt("total_count");
                return totalCount;
            } else {
                throw new NoSuchElementException("값이 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, rs);
        }
    }

    /**
     * 현재 제출 횟수에서 +1하는 메서드
     */
    @Override
    public void totalCountUpdate() {
        // Update문을 통해 totalCount 값을 1 증가
        String sql = "update totalcount set total_count = total_count + 1";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            int result = pstmt.executeUpdate();
            log.info("실행된 행 개수={}", result);
        } catch (SQLException e) {
            log.info("db Error", e);
            throw new RuntimeException(e);
        } finally {
            close(con, pstmt, null);
        }
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
