package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService empService = new EmployeeService();
        ArrayList<EmployeeDTO> allEmp = empService.selectAllEmp();

        String path="";
        if(allEmp!=null){
            path="/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", allEmp);
        }else{
            path="/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "모든 직원 정보 조회 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
