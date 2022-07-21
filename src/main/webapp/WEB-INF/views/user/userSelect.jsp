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
    <title>Title</title>
    <link href="<c:url value="/resources/css/register.css" />" rel="stylesheet">
</head>
<body>

<div class="registerContainer">
    <div class="registerBox left">
        <span class="tit">일반<br></span>
        <span class="tit-desc">만 14세 이상</span>
        <button class="btn-join btn-white-gray" onclick="clickCommon()">일반 14세 이상</button>
    </div>
    <div class="registerBox right">
        <span class="tit">판매자<br></span>
        <span class="tit-desc">만 14세 이상</span>
        <button class="btn-join btn-white-gray" onclick="clickSeller()">판매자</button>
    </div>
</div>

<script>
    function clickCommon() {
        location.href = "memberRegi.do?email=<%=email%>";
    }
    function clickSeller() {
        location.href = "sellerRegi.do?email=<%=email%>";
    }

</script>
</body>
</html>
