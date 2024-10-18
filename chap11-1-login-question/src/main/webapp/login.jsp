
<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-16
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
<%
    String checkStatement="";
    if(request.getCookies().length != 0){
        Cookie [] cookies = request.getCookies();
//        checkStatement = cookies[0].getValue();
        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());
            if(cookies[i].getName().equals("checkStatement")){
                checkStatement=cookies[i].getValue();
            }
        }

    }

//    String checkStatement="";
//    if(request.getAttribute("checkStatement") != null){
//        checkStatement = (String)request.getAttribute("checkStatement");
//    }
%>

    <form action="checkvalid" method="post">
        <h1>로그인 페이지</h1>
        <input type="text" placeholder="User Id" name="userId"/>
        <input type="password" placeholder="Password" name="password">
        <button type="submseit">로그인</button>
    </form>


    <h4 style="color:red;"><%=checkStatement%></h4>

    <br/>

    <a href="register.jsp">가입하기</a>

</body>
</html>
