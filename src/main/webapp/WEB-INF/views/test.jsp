<%@ page import="bossbabies.com.a.dto.TestDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-16
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List<TestDto> dto = (List<TestDto>) request.getAttribute("member");
%>
<h1><%= dto.get(0).getId()%></h1>
<h1><%= dto.get(0).getAddress()%></h1>
</body>
</html>
