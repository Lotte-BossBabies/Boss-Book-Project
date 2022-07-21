<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/20
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findResultPage.css">
</head>
<body>
<% String id = (String) request.getAttribute("id"); %>
<div class="containerBox">
    <div class="resultBox">
        <div class="textBox">
            <p> 회원님의 아이디는 <strong><%=id %></strong> 입니다.</p>
        </div>
        <a class="btn moveBtn" href="findPassword.do">비밀번호찾기</a>
        <a class="btn cancelBtn" href="login.do">돌아가기</a>
    </div>
</div>
</body>
</html>