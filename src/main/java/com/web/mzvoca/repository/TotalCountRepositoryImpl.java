package com.web.mzvoca.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class TotalCountRepositoryImpl implements TotalCountRepository {

    private final DataSource dataSource;

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
                int totalCount = rs.getInt("totalCount");
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

    @Override
    public void totalCountUpdate() {

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
