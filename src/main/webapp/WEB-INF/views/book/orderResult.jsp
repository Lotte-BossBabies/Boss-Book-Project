<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    boolean makeOrderResult = (boolean) request.getAttribute("makeOrderResult");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/font.css">
    <title>MZ BOOK: 주문</title>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/orderResult.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="resultWrapper">
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
    <div class="btnBox">
        <button type="button" onclick="goBook()">구매 계속하기</button>
        <button type="button" onclick="goMyPage()">마이페이지</button>
    </div>
</div>
<%@include file = "../layout/footer.jsp" %>
<script>
    function goBook(){
        location.href = "bookstore.do?cateName=all";
    }
    function goMyPage(){
        location.href = "mypage.do";
    }
</script>
</body>
</html>
