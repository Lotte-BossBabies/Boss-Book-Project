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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/admin.js"></script>
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
        <li><a href="/updateBook.do?sellerId=1&sellStatus=0" onclick="register()">상품등록</a></li>
        <li><a href="/updateDelivery.do" onclick="delivery()">배송관리</a></li>
    </ul>
</div>

<div align="center">

    <div id="selectCategory">
        <select id="categorySelect" onchange="changeBooks()">
            <option value="소설">소설</option>
            <option value="시/에세이">시/에세이</option>
            <option value="예술/대중문화">예술/대중문화</option>
            <option value="사회과학">사회과학</option>
            <option value="역사와 문화">역사와 문화</option>
            <option value="잡지">잡지</option>
            <option value="만화/라이트노벨">만화/라이트노벨</option>
            <option value="유아">유아</option>
            <option value="아동">아동</option>
            <option value="가정과 생활">가정과 생활</option>
            <option value="청소년">청소년</option>
        </select>

        <input type="text" name="keyword" id="keyword" onchange="inputTextCheck()" placeholder="키워드를 입력하세요.">
        <button type="button" onclick="searchButton()">search</button>

        <button type="button" onclick="salesButton()">판매량순</button>

    </div>


    <table id="maintable">
        <%
            for(RegisteredBookDto dto : list) {
            %>
                <tr>
                    <td><img src="<%= dto.getImage_url()%>"></td>
                    <td><%= dto.getTitle()%></td>
                    <td>
                        <button type="button" name="editBtn" id="editBtn" value="<%= dto.getRegistered_book_id()%>" onclick="editButton(<%= dto.getRegistered_book_id()%>)">edit</button>
                    </td>
                    <td>
                        <button type="button" name="cancelBtn" id="cancelBtn" value="<%= dto.getRegistered_book_id()%>" onclick="cancelBookButton(<%= dto.getRegistered_book_id()%>)">cancel</button>
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

<script type="text/javascript">
  document.querySelector('#keyword').addEventListener('keyup',  (e) => {
    if(e.keyCode === 13) {
      searchButton();
    }else if(document.getElementById('keyword').value === '') {

      var sel = document.getElementById('categorySelect');
      var val = sel.options[sel.selectedIndex].value;

      var jsonData = {"sellerId":"1", "category":val, "sellStatus":1};

      getBooks("category.do", jsonData);
    }
  });

</script>

</body>
</html>
