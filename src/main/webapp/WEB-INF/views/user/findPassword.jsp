<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/20
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>비밀번호 찾기</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formPage.css">
</head>
<body>
<div class="findBox">
    <div class="titleBoxForPw">
        <h2>비밀번호 찾기</h2>
    </div>
    <div class="outerInputBox">
        <form class="was-validated" action="findPassword.do" method="get" id="findForm">
            <div class="innerInputBox">
                <label for="id">아이디:</label>
                <input type="text" class="inputs" id="id" placeholder="등록된 아이디 입력" name="id" required="required">
            </div>
            <div class="innerInputBox">
                <label for="name">이름:</label>
                <input type="text" class="inputs" id="name" placeholder="이름 입력" name="name" required="required">
            </div>
            <div class="innerInputBox">
                <label for="email">이메일:</label>
                <input type="email" class="inputs" id="email" placeholder="등록된 이메일 입력" name="email" required="required">
            </div>
        </form>
    </div>
    <div class="buttonBox">
        <button type="button" class="btn submitBtn" onclick="findPasswordByIdAndEmail()">찾기</button>
        <button type="button" class="btn cancelBtn" onclick="gotoLogin()">취소</button>
    </div>
</div>
<script type="text/javascript">
    function findPasswordByIdAndEmail() {
        document.getElementById("findForm").submit();
    }
    function gotoLogin() {
        location.href = "login.do";
    }
</script>
</body>
</html>