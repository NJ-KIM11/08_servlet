package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public EmployeeDTO selectEmpById(Connection con, int empId) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectEmp = new EmployeeDTO();
                selectEmp.setEmpId(rset.getInt("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmp;

    }

    public ArrayList<EmployeeDTO> selectAllEmp(Connection conn) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO allEmp = null;
        ArrayList<EmployeeDTO> allEmps = new ArrayList<EmployeeDTO>();

        String query = prop.getProperty("selectAllEmp");

        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                allEmp = new EmployeeDTO();
                allEmp.setEmpId(rset.getInt("EMP_ID"));
                allEmp.setEmpName(rset.getString("EMP_NAME"));
                allEmp.setEmpNo(rset.getString("EMP_NO"));
                allEmp.setEmail(rset.getString("EMAIL"));
                allEmp.setPhone(rset.getString("PHONE"));
                allEmp.setDeptCode(rset.getString("DEPT_CODE"));
                allEmp.setJobCode(rset.getString("JOB_CODE"));
                allEmp.setSalLevel(rset.getString("SAL_LEVEL"));
                allEmp.setSalary(rset.getInt("SALARY"));
                allEmp.setBonus(rset.getDouble("BONUS"));
                allEmp.setManagerId(rset.getString("MANAGER_ID"));
                allEmp.setHireDate(rset.getDate("HIRE_DATE"));
                allEmp.setEntDate(rset.getDate("ENT_DATE"));
                allEmp.setEntYn(rset.getString("ENT_YN"));
                allEmps.add(allEmp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return allEmps;
    }
}
