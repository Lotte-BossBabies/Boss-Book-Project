<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-19
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 페이지</title>

    <link rel="stylesheet" type="text/css" href="resources/css/adminMain.css">
</head>

<%
    List<RegisteredBookDto> list = (List<RegisteredBookDto>) request.getAttribute("resultList");
%>
<body>

<div>
<p>header</p>
</div>

<div>
    <ul>
        <li><a href="/updateBook.do" onclick="register()">상품등록</a></li>
        <li><a href="/updateDelivery.do" onclick="delivery()">배송관리</a></li>
    </ul>
</div>

<div align="center">

    <div id="selectCategory">
        <select id="categorySelect">
            <option>소설</option>
            <option>시/에세이</option>
            <option>예술/대중문화</option>
            <option>사회과학</option>
            <option>역사와 문화</option>
            <option>잡지</option>
            <option>만화/라이트노벨</option>
            <option>유아</option>
            <option>아동</option>
            <option>가정과 생활</option>
            <option>청소년</option>
        </select>

        <form>
            <input type="text" name="keyword" id="keyword">
            <input type="submit" value="검색" onclick="searchButton()">
        </form>
    </div>


    <table id="maintable">
        <%
            for(RegisteredBookDto dto : list) {
            %>
                <tr>
                    <td><img src="<%= dto.getImage_url()%>"></td>
                    <td><%= dto.getTitle()%></td>
                    <td>
                        <button type="button" onclick="editButton()">편집</button>
                    </td>
                </tr>
            <%
            }
        %>
    </table>

</div>

<div>
<p>footer</p>
</div>

</body>
</html>
