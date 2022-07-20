<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-07-20
  Time: 오후 3:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>관리자 상품 등록 페이지</title>

    <link rel="stylesheet" type="text/css" href="resources/css/adminMain.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/adminRegister.js"></script>
</head>

<%
    List<RegisteredBookDto> list = (List<RegisteredBookDto>) request.getAttribute("resultList");
%>
<body>

<div>
    <p>header</p>
</div>

<h2>판매 해지 상품 목록</h2>

<div align="center">

    <div id="selectCategory">
        <select id="subCategorySelect" onchange="subChangeBooks()">
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

        <input type="text" name="subKeyword" id="subKeyword" onchange="subInputTextCheck()" placeholder="키워드를 입력하세요.">
        <button type="button" onclick="subSearchButton()">search</button>

    </div>


    <table id="subtable">
        <%
            for(RegisteredBookDto dto : list) {
                System.out.println(dto.getRegistered_book_id());
        %>
        <tr>
            <td><img src="<%= dto.getImage_url()%>"></td>
            <td><%= dto.getTitle()%></td>
            <td>
                <button type="button" name="registerBtn" id="registerBtn" value="<%= dto.getRegistered_book_id()%>" onclick="registerBookButton(<%= dto.getRegistered_book_id()%>)">register</button>
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
  document.querySelector('#subKeyword').addEventListener('keyup',  (e) => {
    if(e.keyCode === 13) {
      subSearchButton();
    }else if(document.getElementById('subKeyword').value === '') {

      var sel = document.getElementById('subCategorySelect');
      var val = sel.options[sel.selectedIndex].value;

      var jsonData = {"sellerId":"1", "category":val, "sellStatus":0};

      getNotRegisteredBooks("category.do", jsonData);
    }
  });

</script>

</body>
</html>