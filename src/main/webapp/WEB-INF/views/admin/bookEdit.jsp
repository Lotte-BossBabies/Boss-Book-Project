<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-20
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 상품 수정 페이지</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/admin.js"></script>
</head>
<body>
<%
    RegisteredBookDto dto = (RegisteredBookDto) request.getAttribute("registeredBook");
%>

<div>
    header
</div>

<div align="center">
    <img src="<%= dto.getImage_url()%>">
    <p><%= dto.getTitle()%></p>

    <a>재고량</a>
    <input type="text" id="stock" name="stock" value="<%=dto.getBook_count()%>">

    <br><br>

    <a>할인율</a>
    <input type="text" id="discount" name="discount" value="<%= dto.getDiscount_rate()%>">
    <button type="button" id="updateBtn" name="updateBtn" value="<%= dto.getRegistered_book_id()%>" onclick="updateButton()">수정</button>
    <button type="button" onclick="cancelButton()">취소</button>
</div>


<div>
    footer
</div>


</body>
</html>
