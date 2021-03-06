<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/18
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email = (String)request.getAttribute("email");
    System.out.println("받은 변수 : " + email);
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 회원가입</title>
    <link href="<c:url value="/resources/css/register.css" />" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div class="registerContainer">
    <div class="registerBox left">
        <span class="tit">일반<br></span>
        <span class="tit-desc">만 14세 이상</span>
        <button class="btn-join btn-white-gray" onclick="regiEvent('member')">일반 14세 이상</button>
    </div>
    <div class="registerBox right">
        <span class="tit">판매자<br></span>
        <span class="tit-desc">만 14세 이상</span>
        <button class="btn-join btn-white-gray" onclick="regiEvent('seller')">판매자</button>
    </div>
</div>
<%@include file = "../layout/footer.jsp" %>
<script>
    function regiEvent( userType ) {
        let form = document.createElement("form");
        let input = document.createElement("input");

        form.setAttribute("method", "post");
        if(userType == "member") {
            form.setAttribute("action", "memberRegi.do");
        }
        else if(userType == "seller"){
            form.setAttribute("action", "sellerRegi.do");
        }
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "email");
        input.setAttribute("value", '<%=email%>');

        form.appendChild(input);
        document.body.appendChild(form);
        form.submit();
    }

</script>
</body>
</html>
