<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/20
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    String msg = (String)request.getAttribute("msg");
    System.out.println("jsp msg = " + msg);
%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 비밀번호 찾기</title>

    <link rel="stylesheet" href="/resources/css/font.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formPage.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/js/post.js">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div id="findPassword" class="findBox">
    <div class="titleBoxForPw">
        <h2>비밀번호 찾기</h2>
    </div>
    <div class="outerInputBox">
        <form class="was-validated" action="findPassword.do" method="post" id="findForm">
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
    <div class="buttonBox" id="findPasswordButton">
        <button type="button" id ="submitPassword" class="btn submitBtn">찾기</button>
        <button type="button" class="btn cancelBtn" onclick="gotoLogin()">취소</button>
    </div>
</div>
<script type="text/javascript">
    $("#submitPassword").click(function(){
        let id = document.getElementById("id").value;
        let name = document.getElementById("name").value;
        let email = document.getElementById("email").value;
        let params={
            "id" : id,
            "name" : name,
            "email" : email
        }
        console.log(params);
        $.ajax({
            url:"findPassword.do",
            type:"POST",
            data : JSON.stringify(params),
            contentType: "application/json;charset=UTF-8",
            dataType: "text",
            success:function (password){
                if(password == "nothing"){
                    alert("회원 정보 입력 오류");
                    location.href="findPasswordView.do";
                }
                else{
                    passwordFind(password);
                }
            },
            error:function (){
                alert("error");
            }
        });
    });
    function gotoLogin() {
        location.href = "login.do";
    }
</script>

<%@include file = "../layout/footer.jsp" %>
</body>
</html>