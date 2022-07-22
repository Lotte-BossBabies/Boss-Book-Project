<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    BookDto dto = (BookDto) request.getAttribute("book");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>상품 등록 상세 페이지</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/font.css">

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/bookRegister.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>

<div class="bookRegisterBox">
    <div class="titleBox">
        도서 등록 하기
    </div>

    <div class="lineBox"></div>

    <div class="bookInfoBox">
        <img src="<%= dto.getImage_url()%>">
        <p><%= dto.getTitle()%></p>
    </div>

    <div class="inputBox">
        <form action="insertRegisterBook.do" method="post">
            <div class="inputs">
                재고량 : <input type="text" name="bookCount">
            </div>
            <div class="inputs">
                할인율 : <input type="text" name="discountRate">
            </div>
            <input type="hidden" name="bookId" value="<%= dto.getBook_id()%>"><br>

            <button type="submit" name="submitBtn">등록하기</button>
            <button type="button" onclick="location.href='adminMain.do'">취소하기</button>
        </form>
    </div>
</div>
<%@include file = "../layout/footer.jsp" %>
</body>
</html>
