package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeletePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int postId = Integer.parseInt(req.getParameter("id"));

        BoardService boardService = new BoardService();
        int result = boardService.deletePost(postId);
        int result2 = boardService.resetPostId(postId);

        String path="";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "deletePost");
        }else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 삭제에 실패!!");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
