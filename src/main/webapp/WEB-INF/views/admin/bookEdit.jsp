<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RegisteredBookDto dto = (RegisteredBookDto) request.getAttribute("registeredBook");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 상품 수정</title>

    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/bookRegister.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/admin.js"></script>

</head>
<body>

<%@include file = "../layout/header.jsp" %>
<div class="bookRegisterBox">
    <div class="titleBox">
        판매 정보 수정 하기
    </div>

    <div class="lineBox"></div>

    <div class="bookInfoBox">
        <img src="<%= dto.getImage_url()%>">
        <p><%= dto.getTitle()%></p>
    </div>

    <div class="inputBox">
        <div class="inputs">
            재고량 : <input type="text" id="stock" name="stock" value="<%=dto.getBook_count()%>">
        </div>
        <div class="inputs">
            할인율 : <input type="text" id="discount" name="discount" value="<%= dto.getDiscount_rate()%>">
        </div>
        <br>

        <button type="button" id="updateBtn" name="updateBtn" value="<%= dto.getRegistered_book_id()%>" onclick="updateButton()">수정</button>
        <button type="button" onclick="cancelButton()">취소</button>
    </div>
</div>

<%@include file = "../layout/footer.jsp" %>

</body>
</html>
