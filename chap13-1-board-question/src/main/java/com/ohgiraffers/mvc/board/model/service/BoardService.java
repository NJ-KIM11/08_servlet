package com.ohgiraffers.mvc.board.model.service;

import com.ohgiraffers.mvc.board.model.dao.BoardDAO;
import com.ohgiraffers.mvc.board.model.dto.BoardDTO;

import java.sql.Connection;
import java.util.ArrayList;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

public class BoardService {

    private final BoardDAO boardDAO;

    public BoardService() {
        boardDAO = new BoardDAO();
    }


    public ArrayList<BoardDTO> selectAllPost() {

        Connection conn = getConnection();

        ArrayList<BoardDTO> wholePost = boardDAO.selectAllPost(conn);

        close(conn);

        return wholePost;
    }

    public BoardDTO selectOnePostById(int postId) {

        Connection conn = getConnection();
        BoardDTO post = boardDAO.selectOnePostById(conn, postId);

        close(conn);

        return post;
    }

    public int selectNewPostId() {
        Connection conn = getConnection();
        int postId = boardDAO.selectNewPostId(conn);
        close(conn);
        return postId;
    }

    public int insertPost(BoardDTO newPost) {
        Connection conn = getConnection();
        int result = boardDAO.insertPost(conn, newPost);
        if (result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }

    public int updatePost(BoardDTO editPost) {
        Connection conn = getConnection();
        int result = boardDAO.updatePost(conn, editPost);
        if (result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }

    public int deletePost(int postId) {
        Connection conn = getConnection();
        int result = boardDAO.deletePost(conn, postId);

        if (result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }

    public int resetPostId(int postId) {
        Connection conn = getConnection();
        int result = boardDAO.resetPostId(conn, postId);

        if (result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
}
