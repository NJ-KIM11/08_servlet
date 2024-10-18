package com.ohgiraffers.mvc.board.model.dao;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.common.config.ConfigLocation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class BoardDAO {

    private final Properties prop;

    public BoardDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "board-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<BoardDTO> selectAllPost(Connection conn) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        BoardDTO post = null;
        ArrayList<BoardDTO> allPost = new ArrayList<BoardDTO>();

        String query = prop.getProperty("selectAllPost");

        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                post = new BoardDTO();
                post.setPostId(rset.getInt("POST_ID"));
                post.setTitle(rset.getString("TITLE"));
                post.setContent(rset.getString("CONTENT"));
                allPost.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(rset);
        }

        return allPost;
    }

    public BoardDTO selectOnePostById(Connection conn, int postId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        BoardDTO post = null;

        String query = prop.getProperty("selectOnePostById");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                post = new BoardDTO();
                post.setPostId(rset.getInt("POST_ID"));
                post.setTitle(rset.getString("TITLE"));
                post.setContent(rset.getString("CONTENT"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(rset);
        }
        return post;
    }

    public int selectNewPostId(Connection conn) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String query = prop.getProperty("selectNewPostId");
        int newPostId = 0;

        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                newPostId = rset.getInt("POST_ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(rset);
        }
        return newPostId;
    }

    public int insertPost(Connection conn, BoardDTO newPost) {

        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertPost");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, newPost.getPostId());
            pstmt.setString(2, newPost.getTitle());
            pstmt.setString(3, newPost.getContent());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int updatePost(Connection conn, BoardDTO editPost) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updatePost");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, editPost.getTitle());
            pstmt.setString(2, editPost.getContent());
            pstmt.setInt(3, editPost.getPostId());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int deletePost(Connection conn, int postId) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deletePost");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int resetPostId(Connection conn, int postId) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("resetPostId");

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, postId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }
}
