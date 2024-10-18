<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-18
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
    게시글 번호 : ${requestScope.post.postId} <br/>
    제목 : ${requestScope.post.title} <br/>
    내용 : ${requestScope.post.content} <br/>
    <a href="selectAll">돌아가기</a>
</body>
</html>
