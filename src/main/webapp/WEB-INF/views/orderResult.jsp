<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean makeOrderResult = (boolean) request.getAttribute("makeOrderResult");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>구매 결과</h2>
<div>
    <%
        if(makeOrderResult){
    %>
    구매에 성공하였습니다.
    <%
    } else {
    %>
    구매에 과정에 문제가 있습니다.
    <%
        }
    %>
</div>

<a href="getDetailedBook.do?registered_book_id=2">쇼핑 더하기</a>
<a href="getDetailedBook.do?registered_book_id=2">마이페이지</a>

</body>
</html>
