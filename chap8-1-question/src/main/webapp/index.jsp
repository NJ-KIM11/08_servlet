<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>8-1 question</title>
</head>
<body>
<%
    String check1="";
    String check2="";

    if(request.getAttribute("titleIsValid") == null){
        check1 = "";
        check2 = "";
    }else{
        if(!(boolean)request.getAttribute("titleIsValid")){
            check1 = "제목은 5자 이상이어야 합니다.";
        }else if(!(boolean)request.getAttribute("contentIsValid")){
            check2 = "내용은 10자 이상이어야 합니다.";
        }
    }
%>
<h2><%=check1%></h2>
<h2><%=check2%></h2>

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