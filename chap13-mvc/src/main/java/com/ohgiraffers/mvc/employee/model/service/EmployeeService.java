package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.ArrayList;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    private final EmployeeDAO empDAO;

    // EmployeeService 객체가 생길 때(생성자가 호출될때) EmployeeDAO 객체도 자동생성
    public EmployeeService(){
        empDAO = new EmployeeDAO();
    }

    public EmployeeDTO selectOneEmpById(int empId) {

        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);

        close(con);

        return selectEmp;
    }

    public ArrayList<EmployeeDTO> selectAllEmp() {

        Connection conn = getConnection();

        ArrayList<EmployeeDTO> wholeEmp = empDAO.selectAllEmp(conn);

        close(conn);

        return wholeEmp;
    }
}
