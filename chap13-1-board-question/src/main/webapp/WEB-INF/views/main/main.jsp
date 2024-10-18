<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-18
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Main</title>
</head>
<body>

    <jsp:include page="../common/newPost.jsp"/>

    <br/>

    <h1>게시글 목록</h1>

    <c:choose>
        <c:when test="${empty requestScope.postList}">
            <h3>게시글이 없습니다.</h3>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>ID</th>
                    <th>제목</th>
                    <th>작업</th>
                </tr>
                <hr>
                <c:forEach items="${requestScope.postList}" var="post">
                    <tr>
                        <td>${post.postId}</td>
                        <td> <a href="detail?id=${post.postId}">${post.title}</a> </td>
                        <td> <a href="edit?id=${post.postId}">수정</a> <a href="delete?id=${post.postId}">삭제</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>


</body>
</html>
