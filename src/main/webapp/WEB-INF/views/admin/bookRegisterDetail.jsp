<%@ page import="bossbabies.com.a.dto.BookDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-21
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 등록 상세 페이지</title>
</head>
<body>

<%
    BookDto dto = (BookDto) request.getAttribute("book");
%>

<img src="<%= dto.getImage_url()%>">
<p><%= dto.getTitle()%></p>

<form action="insertRegisterBook.do" method="post">
    재고량 : <input type="text" name="bookCount">
    할인율 : <input type="text" name="discountRate">
    <input type="hidden" name="bookId" value="<%= dto.getBook_id()%>">

    <input type="submit" name="submitBtn" value="등록">
</form>


</body>
</html>
