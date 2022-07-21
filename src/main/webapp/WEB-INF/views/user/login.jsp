<%@ page import="org.springframework.beans.factory.annotation.Value" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="@apiProperties['client_id']" var="client_id"/>
<spring:eval expression="@apiProperties['redirect_uri']" var="redirect_uri"/>
<spring:eval expression="@apiProperties['logout_redirect_uri']" var="logout_redirect_uri"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/login.js" />"></script>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">


    <style type="text/css">
        .center {
            margin: auto;
            width: 60%;
            padding: 10px;
        }
    </style>
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="everything">
    <div class="member_login_wrap">
        <div class="contents_inner">
            <div class="login_box">
                <div class="titleBox">
                    <h1>로그인</h1>
                </div>

                <form action="loginAf.do" method="get">
                    <div class="login_area">
                        <div class="login_input">
                            <input type="text" id="id" name="id" maxlength="50" placeholder="아이디를 입력해 주세요"><br>

                            <input type="password" name="password" maxlength="15" placeholder="비밀번호를 입력해 주세요">
                        </div>
                        <input type="hidden" name="hidLoginType" id="hidLoginType" value="">
                        <%--      <input type="submit" value="로그인">--%>
                        <button type="submit" class="btn_login">로그인</button>
                    </div>
                </form>

                <div class="login_bot_wrap">
                    <div class="label">
                        <%--@declare id="rememberid"--%><label for="rememberID"><input class="check_box" type="checkbox" name="rememberID" id="rememberID">아이디 저장</label>
                    </div>
                    <div id = "util" class="util">
                        <a href="<%=request.getContextPath() %>/userSelect.do" style="text-decoration-line: none">회원가입</a> &nbsp |  &nbsp
                        <a href="<%=request.getContextPath() %>/findId.do" style="text-decoration-line: none">아이디찾기</a> &nbsp |  &nbsp
                        <a href="<%=request.getContextPath() %>/findPassword.do" style="text-decoration-line: none">비밀번호찾기</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="loginwith"style="text-align: center">
        <a class="p-2" href="https://kauth.kakao.com/oauth/authorize?client_id=${client_id}&redirect_uri=${redirect_uri}&response_type=code">
            <img src="${pageContext.request.contextPath}/resources/images/kakao_login_medium_wide.png" >
            <!-- 이미지는 카카오 개발자센터에서 제공하는 login 이미지를 사용했습니다. -->
        </a>
    </div>
</div>
<button onclick="kakaoLogout()">카카오 로그아웃</button>
<%@include file = "../layout/footer.jsp" %>
</body>
<script>
    function kakaoLogout(){
        location.href = "https://kauth.kakao.com/oauth/logout?client_id=${client_id}&logout_redirect_uri=${logout_redirect_uri}";
    }

</script>
</html>


