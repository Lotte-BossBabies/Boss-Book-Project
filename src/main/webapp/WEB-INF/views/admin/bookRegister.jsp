<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 상품 등록</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" type="text/css" href="resources/css/adminMain.css">
    <link rel="stylesheet" href="/resources/css/font.css">
    <script type="text/javascript" src="resources/js/adminRegister.js"></script>
    <script type="text/javascript" src="resources/js/paging.js"></script>
</head>

<%
    List<BookDto> list = (List<BookDto>) request.getAttribute("resultList");
%>
<body>
<div class="wrap">
    <%@include file="../layout/header.jsp" %>

    <div class="bookWrapper">
        <div class="titleBox">
            <a href="adminMain.do">돌아가기</a>
        </div>

        <span class="title">판매 가능한 책</span><br>
        <div class="lineBox"></div>

        <div class="contentBox">
            <div class="selectCategory">
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
                <button type="button" id="subSearchBtn" onclick="subSearchButton()">search</button>

            </div>

            <div class="tableBox">
                <table id="subtable">
                    <%
                        for(BookDto dto : list) {
                            //System.out.println(dto.getBook_id());
                    %>
                    <tr>
                        <td><img id="bookImg" src="<%= dto.getImage_url()%>"></td>
                        <td><%= dto.getTitle()%></td>
                        <td>
                            <button type="button" name="registerBtn" id="registerBtn" value="<%= dto.getBook_id()%>" onclick="registerBookButton(<%= dto.getBook_id()%>)">register</button>
                        </td>
                        <td></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>

    </div>
    <%@include file="../layout/footer.jsp" %>

</div>


<script type="text/javascript">
  document.querySelector('#subKeyword').addEventListener('keyup',  (e) => {
    if(e.keyCode === 13) {
      subSearchButton();
    }else if(document.getElementById('subKeyword').value === '') {

      var sel = document.getElementById('subCategorySelect');
      var val = sel.options[sel.selectedIndex].value;

      var jsonData = {"sellerId":"1", "category":val, "sellStatus":0};

      getNotRegisteredBooks("notRegisteredBooks.do", jsonData);
    }
  });

</script>

</body>
</html>
