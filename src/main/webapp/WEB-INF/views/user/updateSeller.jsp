<%@ page import="bossbabies.com.a.dto.user.SellerDto" %><%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/19
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    SellerDto seller = (SellerDto) request.getAttribute("seller");
    String id = seller.getId();
    String name = seller.getName();
    String email = seller.getEmail();
    String phone = seller.getPhone();
    String store_name = seller.getStore_name();
%>
<html>
<head>
    <script type="text/javascript">
        function updateUser() {
            alert("sdf");
            document.getElementById("platform").submit();
        }
    </script>
    <title>MZ BOOK: 회원정보 수정</title>
    <link href="<c:url value="/resources/css/userupdate.css" />" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <style>
        .updateContainer{
            margin-bottom: 100px;
        }

        .titleBox {
            margin: 50px auto 30px;
            width: 70%;
            height: 50px;
            text-align: center;
            font-size: 24px;
        }

        .lineBox{
            width: 60%;
            margin: auto;
            border-bottom: 1px solid #bbbbbb;
        }

        .userinfo {
            width: 40%;
            margin: 10px auto;
        }

        .user {
            display: flex;
            justify-items: flex-end;
            justify-content: flex-end;
        }

        .blank {
            width: 100px;
            height: 40px;
        }

        .infoinput {
            width: 320px;
            height: 40px;
            margin: 10px;
        }

        .text {
            margin-top: 25px;
            padding: 0;
            width: 158px;
        }

        .updateBtn {
            margin-top: 30px;
        }

        .cancelBtn {
            width: 100px;
            height: 40px;
            margin: 5px 20px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 20px;
            cursor: pointer;
        }

        .cancelBtn:hover {
            border: 2px solid #3CAE76;
            color: #3CAE76;
        }

        .confirmBtn:hover {
            border: 2px solid #3CAE76;
            color: #3CAE76;
        }

        .confirmBtn {
            width: 100px;
            height: 40px;
            margin-top: 5px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="updateContainer">
    <div class="titleBox">회원정보 수정</div>

    <div class="lineBox"></div>

    <div class="userinfo">
        <form action="updateSeller.do" method="get" id="platform">
            <div class="user">
                <div class="text">아이디</div>
                <input name="id" type="text" class="infoinput" id="id" value="<%= id%>" readonly>
                <span class="blank"></span>
            </div>
            <div class="user">
                <div class="text">이름</div>
                <input name="name" type="text" class="infoinput" id="name" value="<%= name%>" readonly>
                <span class="blank"></span>
            </div>
            <div class="user">
                <div class="text">이메일</div>
                <input name="email" type="text" class="infoinput" id="email" value="<%= email%>" readonly>
                <span class="blank"></span>
            </div>
            <div class="user">
                <div class="text">비밀번호</div>
                <input name="password" type="password" class="infoinput" id="password" required="required" onkeyup="return passwordChanged()">
                <span id="strength" class="blank">Type Password</span>
            </div>
            <div class="user">
                <div class="text">비밀번호 확인</div>
                <input name="pwdCheck" type="password" class="infoinput" id="pwdCheck" required="required" onkeyup="return passwordMatch()">
                <span id="passMatch" class="blank">Type Password</span>
            </div>
            <div class="user">
                <div class="text">핸드폰</div>
                <input name="phone" type="text" class="infoinput" id="phone" value="<%= phone%>">
                <span class="blank"></span>
            </div>
            <div class="user">
                <div class="text">스토어 이름</div>
                <input name="store_name" type="text" class="infoinput" id="store_name" value="<%= store_name%>">
                <span class="blank"></span>
            </div>
            <div class="updateBtn" align="center">
                <button type="button" class="cancelBtn" onclick="location.href='adminMain.do?sellStatus=1'">취소하기</button>
                <button type="submit" class="confirmBtn" onclick="formSubmit()">수정하기</button>
            </div>
        </form>
    </div>
</div>
<%@include file = "../layout/footer.jsp" %>
<script>

    function checkForm() {
        if(document.getElementById("pwd").value !== document.getElementById("confirmPwd").value) {
            alert("패스워드가 일치하지 않습니다!");
            return false;
        }
        // if(document.getElementById("flag").value != document.getElementById("id").value) {
        //     alert("인증받은 아이디가 아닙니다 \n아이디 중복확인하세요");
        //     return false;
        // }
    }

    function checkId() {
        let memberId = document.getElementById("id");
        if(memberId.value === "") {
            alert("아이디를 입력하세요!");
            memberId.focus();
        }else {
            window.open("IdCheckServlet?id=" + memberId.value, "idcheckpopup", "width=250, height=150, top=150, left=400");
        }
    }

    function formSubmit() {
        let result = checkForm();
        if(result === false) {
            return false;
        } else {
            alert("회원가입이 완료되었습니다. \n홈페이지로 돌아갑니다.");
            document.getElementById("form").submit();
        }
    }

    function passwordMatch() {
        var match = document.getElementById('passMatch');
        var pswd = document.getElementById("pwdCheck");
        var pwd = document.getElementById("pwd");
        if(pswd.value.length === 0) { //')' token error duplicate, syntax error 발생지점
            match.innerHTML = 'Type Password';
        } else if (pwd.value ===  pswd.value) {
            match.innerHTML = '<span style="color:green">비밀번호 확인완료!</span>';
        } else {
            match.innerHTML = '<span style="color:red">비밀번호가 일치하지 않습니다!</span>';
        }
    }
    function passwordChanged() {
        var strength = document.getElementById('strength');
        var strongRegex = new RegExp("^(?=.{8,})(?=.*[a-zA-Z])(?=.*[0-9])(?=.*\\W).*$", "g");
        var mediumRegex = new RegExp("^(?=.{8,})(((?=.*[a-zA-Z])(?=.*[0-9]))|((?=.*[a-zA-Z])(?=.*[0-9]))).*$", "g");
        var enoughRegex = new RegExp("(?=.{6,}).*", "g");
        var pwd = document.getElementById("pwd");
        if (pwd.value.length === 0) {
            strength.innerHTML = 'Type Password';
        } else if (false === enoughRegex.test(pwd.value)) {
            strength.innerHTML = '<span style="color:red">길이가 짧습니다!</span>';
        } else if (strongRegex.test(pwd.value)) {
            strength.innerHTML = '<span style="color:green">Strong!</span>';
        } else if (mediumRegex.test(pwd.value)) {
            strength.innerHTML = '<span style="color:orange">Medium!</span>';
        } else {
            strength.innerHTML = '<span style="color:rosybrown">Weak!</span>';
        }
    }
</script>
</body>
</html>