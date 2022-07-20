<%@ page import="bossbabies.com.a.dto.BookDto" %><%--
  Created by IntelliJ IDEA.
  User: BTC-N01
  Date: 2022-07-19
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BookDto book = (BookDto) request.getAttribute("book");
    int bookId = Integer.parseInt(request.getParameter("bookId"));
    int memberId = Integer.parseInt(request.getParameter("memberId"));
%>
<html>
<head>
    <title>리뷰 작성</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css'>


</head>
<body>

<h1>리뷰 작성</h1>
<h2><%=book.getTitle()%></h2>

<form action="writeReviewAf.do" method="post">
    <input type="hidden" name="bookId" value="<%=bookId%>">
    <input type="hidden" name="memberId" value="<%=memberId%>">

    <table>
        <tr>
            <th>내용</th>
            <td style="text-align: left;">
                <div class="form-group">
                    <label for="exampleTextarea" class="form-label mt-4">리뷰 작성</label>
                    <textarea class="form-control" id="exampleTextarea" rows="7" cols="50" placeholder="최소 10자 이상 입력해주세요."></textarea>
                </div>
            </td>
        </tr>
        <tr>
            <th>별점</th>
            <td style="text-align: left;"><input type="number" name="star" min="0" max="5"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" class="btn btn-primary">작성하기</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
