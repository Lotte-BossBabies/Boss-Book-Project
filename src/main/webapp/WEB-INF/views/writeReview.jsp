<%--
  Created by IntelliJ IDEA.
  User: BTC-N01
  Date: 2022-07-19
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int bookId = Integer.parseInt(request.getParameter("bookId"));
    int memberId = Integer.parseInt(request.getParameter("memberId"));
%>
<html>
<head>
    <title>리뷰 작성</title>
</head>
<body>

<h1>리뷰 작성</h1>

<form action="writeReviewAf.do" method="post">
    <input type="hidden" name="bookId" value="<%=bookId%>">
    <input type="hidden" name="memberId" value="<%=memberId%>">

    <table>
        <tr>
            <th>내용</th>
            <td style="text-align: left;">
                <textarea rows="10" cols="50" name="content"></textarea>
            </td>
        </tr>
        <tr>
            <th>별점</th>
            <td style="text-align: left;"><input type="number" name="star" min="0" max="5"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="작성하기">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
