<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean makeOrderResult = (boolean) request.getAttribute("makeOrderResult");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/orderResult.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<h2>구매 결과</h2>
<div class="resultBox">
    <%
        if(makeOrderResult){
    %>
        <div class="resultContent">
        구매에 성공하였습니다.
        </div>
    <%
    } else {
    %>
        <div class="resultContent">
        구매에 과정에 문제가 있습니다.
        </div>
    <%
        }
    %>
</div>
<div class="aBox">
    <a href="getDetailedBook.do?registered_book_id=2">쇼핑 더하기</a>
    <a href="getDetailedBook.do?registered_book_id=2">마이페이지</a>
</div>
<%@include file = "../layout/footer.jsp" %>
</body>
</html>
