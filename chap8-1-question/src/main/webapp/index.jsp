<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>8-1 question</title>
</head>
<body>

<form action="writepost" method="post" >
    <h1>게시글 작성</h1>
    <br>
    <label>제목 : </label><input type="text" name="title">
    <br>
    <label>내용 : </label><textarea name="content"></textarea>
    <br>
    <input type="submit" value="작성하기"/>

</form>
</body>
</html>