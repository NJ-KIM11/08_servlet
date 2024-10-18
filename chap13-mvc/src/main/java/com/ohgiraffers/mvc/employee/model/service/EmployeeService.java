package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

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

    public int selectNemEmpId() {

        // AUTO_INCREMENT 가 걸려있는 경우는 필요 없지만, 제일 끝 번호를 추적해 직접 값을 넣어주는 메소드
        Connection conn = getConnection();
        int newEmpId  = empDAO.selectNewEmpId(conn);
        close(conn);

        return newEmpId;
    }

    public int insertEmp(EmployeeDTO emp) {

        Connection conn = getConnection();
        int result = empDAO.insertEmp(conn, emp);
        if (result > 0) {
            commit(conn);
        }else{
            rollback(conn);
        }

        close(conn);
        return result;
    }

    public int updateEmp(int empId, Date entDate) {

        Connection conn = getConnection();
        int result = empDAO.updateEmp(conn, empId, entDate);

        if (result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }

        close(conn);
        return result;
    }

    public int deleteEmp(int empId) {

        Connection conn = getConnection();
        int result = empDAO.deleteEmp(conn, empId);

        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);
        return result;
    }
}
