<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/20
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <meta charset="UTF-8">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findResultPage.css">
</head>
<body>
<% String password = (String) request.getAttribute("password"); %>
<div class="containerBox">
    <div class="resultBox">
        <div class="textBox">
            <p> 회원님의 비밀번호 &nbsp;<strong><%=password %></strong> 입니다.</p>
        </div>
        <a class="btn cancelBtn" href="login.do">돌아가기</a>
    </div>
</div>
</body>
</html>