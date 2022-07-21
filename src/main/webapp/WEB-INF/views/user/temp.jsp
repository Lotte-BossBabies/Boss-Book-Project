<%@ page import="bossbabies.com.a.dto.user.MemberDto" %>
<%@ page import="bossbabies.com.a.dto.user.SellerDto" %><%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/19
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userType = (String)session.getAttribute("userType");
    Object user = null;
    if(userType.equals("member")){
        user = (MemberDto)session.getAttribute("login");
    }
    else if(userType.equals("seller")){
        user = (SellerDto)session.getAttribute("login");
    }
    System.out.println(user);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/updateUser.do" style="text-decoration-line: none">회원정보수정</a>

</body>
</html>
