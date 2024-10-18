<%--
  Created by IntelliJ IDEA.
  User: 803-08
  Date: 2024-10-18
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CUD 성공</title>
</head>
<body>

    <script>
        (function (){
            const successCode = '${requestScope.successCode}'
            let successMessage = "";

            switch (successCode){
                case 'insertPost' :
                    successMessage = "새 게시글 등록 성공!"
                    break;
                case 'updatePost' :
                    successMessage = "게시글 수정 성공!!"
                    break;
                case 'deletePost' :
                    successMessage = "게시글 삭제 성공!!!"
                    break;
            }
            alert(successMessage);
            location.href = '${pageContext.servletContext.contextPath}/selectAll';

        })();

    </script>

</body>
</html>
