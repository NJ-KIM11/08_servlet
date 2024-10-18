package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class UpdatePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("postId", postId);
        req.getRequestDispatcher("/WEB-INF/views/board/editBoard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("postId"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardDTO editPost = new BoardDTO();
        editPost.setPostId(postId);
        editPost.setTitle(title);
        editPost.setContent(content);

        BoardService boardService = new BoardService();
        int result = boardService.updatePost(editPost);

        String path="";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "updatePost");
        }else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 수정에 실패!!");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
