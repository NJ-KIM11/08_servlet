package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/detail")
public class SelectOnePostByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int postId = Integer.parseInt(req.getParameter("id"));

        BoardService boardService = new BoardService();
        BoardDTO post = boardService.selectOnePostById(postId);

        String path="";
        if(post!=null){
            path="/WEB-INF/views/board/showOnePost.jsp";
            req.setAttribute("post", post);
        }else {
            path="/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "게시글 보기에 실패했습니다!");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
