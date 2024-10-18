<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-18
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRUD 성공</title>
</head>
<body>

    <script>
      (function (){
        const successCode = '${requestScope.successCode}'
        let successMessage = "";

        switch (successCode){
          case 'insertEmp' :
            successMessage = "신규 직원 등록 성공!";
            break;
          case 'updateEmp' :
            successMessage = "직원 정보 수정 성공!!";
            break;
          case 'deleteEmp' :
            successMessage = "직원 정보 삭제 성공!!!";
            break;
        }
        alert(successMessage);
        location.href = '${pageContext.servletContext.contextPath}/employee/list';
      })();
    </script>

</body>
</html>
