package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/newBoard")
public class NewPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/board/newBoard.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardService boardService = new BoardService();
        int newPostId = boardService.selectNewPostId();
        System.out.println(newPostId);

        BoardDTO newPost = new BoardDTO();
        if (newPostId == 0) {newPostId++;}
        if (newPostId > 0) {
            newPost.setPostId(newPostId);
            newPost.setTitle(title);
            newPost.setContent(content);
        }

        int result = boardService.insertPost(newPost);

        String path="";
        if (result > 0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "insertPost");
        }else{
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "새 게시글 작성에 실패!!");
        }

        req.getRequestDispatcher(path).forward(req, resp);

    }
}
