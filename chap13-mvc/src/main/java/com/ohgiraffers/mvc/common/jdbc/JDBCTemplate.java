package com.ohgiraffers.mvc.common.jdbc;


import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// JDBC 연결을 관리하는 클래스
public class JDBCTemplate {

    // DB 연결을 생성하는 정적 메소드
    public static Connection getConnection() {

        Connection conn = null;

        Properties prop = new Properties();

        try {
            prop.load(new FileReader(ConfigLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            Class.forName(driver);

            conn = DriverManager.getConnection(url,user,password);

            conn.setAutoCommit(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
