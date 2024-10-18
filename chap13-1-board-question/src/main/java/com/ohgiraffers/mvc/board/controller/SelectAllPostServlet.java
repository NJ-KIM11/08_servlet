package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAll")
public class SelectAllPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardService boardService = new BoardService();
        ArrayList<BoardDTO> allPost = boardService.selectAllPost();

        String path = "/WEB-INF/views/main/main.jsp";
        req.setAttribute("postList", allPost);
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
