<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-18
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new Board</title>
</head>
<body>

    <h1>새 게시글 작성</h1>
    <br/>
    <form action="newBoard" method="post">
        <label>제목 : </label>
        <input type="text" name="title"/>
        <br/>
        <label>내용 : </label>
        <textarea name="content"></textarea>
        <br/>
        <input type="submit" value="작성하기"/>
    </form>

    <a href="selectAll">돌아가기</a>

</body>
</html>
