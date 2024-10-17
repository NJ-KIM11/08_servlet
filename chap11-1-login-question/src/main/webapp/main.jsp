<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-16
  Time: 오후 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<%
    if(request.getAttribute("userId")==null){
        response.sendRedirect("/login.jsp");
    }
    String id = (String)request.getAttribute("userId");
%>

    <h1>환영합니다! <%=id%> 님!</h1>

    <a href="login.jsp">로그아웃</a>
</body>
</html>
