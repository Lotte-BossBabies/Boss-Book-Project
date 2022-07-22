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
    <title>MZ BOOK: 아이디 찾기</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/formPage.css">
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/js/post.js">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="findBox">
    <div class="titleBox">
        <h3>아이디 찾기</h3>
    </div>
    <div class="outerInputBox">
        <form action="findId.do" method="post" id="findForm">
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
        <button type="button" id = "submitId" class="btn submitBtn">찾기</button>
        <button type="button" class="btn cancelBtn" onclick="gotoLogin()">취소</button>
    </div>
</div>

<script type="text/javascript">
    $("#submitId").click(function(){
        alert("hihi");
        let name = document.getElementById("name").value;
        let email = document.getElementById("email").value;
        let params={
            "name" : name,
            "email" : email
        }
        console.log(params);
        $.ajax({
            url:"findId.do",
            type:"POST",
            data : JSON.stringify(params),
            contentType: "application/json;charset=UTF-8",
            dataType: "text",
            success:function (my_id){
                if(my_id == "nothing"){
                    alert("회원 정보 입력 오류");
                    location.href="findIdView.do";
                }
                else{
                    idFind(my_id);
                }
            },
            error:function (resp){
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
