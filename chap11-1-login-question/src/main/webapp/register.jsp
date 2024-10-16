<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-16
  Time: 오후 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

    <form action="register/member" method="post">
        <h1>회원가입</h1>
        <input type="text" placeholder="User Id" name="userId" required/>
        <input type="password" placeholder="Password" name="password" required>
        <input type="email" placeholder="Email" name="email" required>
        <button type="submit">가입하기</button>
    </form>

    <br/>

    <a href="login.jsp">로그인화면</a>

</body>
</html>
