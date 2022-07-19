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
<%=makeOrderResult %>

<a href="getDetailedBook.do?registered_book_id=2">상세페이지로 가기</a>

</body>
</html>
