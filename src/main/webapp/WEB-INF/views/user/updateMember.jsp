<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bossbabies.com.a.dto.user.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberDto member = (MemberDto) request.getAttribute("member");
    String id = member.getId();
    String name = member.getName();
    String email = member.getEmail();
    String address = member.getAddress();
    String phone = member.getPhone();
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
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="container">
    <div class="redbox">회원정보 수정</div>
    <div class="userinfo">

        <form action="updateMember.do" method="get" id="platform">
            <input type="hidden" id="flag" value="updateUser" name="param">
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
                <div class="text">주소</div>
                <input name="address" type="text" class="infoinput" id="address" value="<%= address%>">
                <span class="blank"></span>
            </div>
            <div class="user">
                <div class="text">핸드폰번호</div>
                <input name="phone" type="text" class="infoinput" id="phone" value="<%= phone%>">
                <span class="blank"></span>
            </div>
            <div class="updateBtn" align="center">
                <input type="button" class="cancelBtn" value="취소" onclick="location.href='mypage.do'">
                <input type="submit" class="confirmBtn" value="확인" onclick="formSubmit()">
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