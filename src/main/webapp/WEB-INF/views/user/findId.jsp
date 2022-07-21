<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/20
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formPage.css">
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="findBox">
    <div class="titleBox">
        <h2>아이디 찾기</h2>
    </div>
    <div class="outerInputBox">
        <form action="findId.do" method="get" id="findForm">
            <div class="innerInputBox">
                <label for="name">이름 :</label>
                <input class="inputs" type="text" id="name" placeholder="등록된 이름 입력" name="name" required="required">
            </div>
            <div class="innerInputBox">
                <label for="email">이메일 :</label>
                <input class="inputs" type="text" id="email" placeholder="등록된 이메일 입력" name="email" required="required">
            </div>
        </form>
    </div>
    <div class="buttonBox">
        <button type="button" class="btn submitBtn" onclick="findIdByNameAndEmail()">찾기</button>
        <button type="button" class="btn cancelBtn" onclick="gotoLogin()">취소</button>
    </div>
</div>

<script type="text/javascript">
    function findIdByNameAndEmail() {
        document.getElementById("findForm").submit();
    }
    function gotoLogin() {
        location.href = "login.do";
    }
</script>
<%@include file = "../layout/footer.jsp" %>
</body>
</html>
