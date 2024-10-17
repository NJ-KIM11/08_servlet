<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-17
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emp Search Result</title>
</head>
<body>

    <jsp:include page="../common/header.jsp"/>

    사원 번호 : ${requestScope.selectEmp.empId} <br/>
    사원 명 : ${requestScope.selectEmp.empName} <br/>
    부서 코드 : ${requestScope.selectEmp.deptCode} <br/>
    직급 코드 : ${requestScope.selectEmp.jobCode} <br/>
    급여 : ${requestScope.selectEmp.salary}

</body>
</html>
