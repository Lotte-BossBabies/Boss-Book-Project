<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.user.SellerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 마이페이지</title>

    <script src="<c:url value="/resources/js/post.js" />"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/adminMain.css">
    <link rel="stylesheet" href="/resources/css/font.css">

    <script type="text/javascript" src="resources/js/admin.js"></script>
</head>

<%
    List<RegisteredBookDto> list = (List<RegisteredBookDto>) request.getAttribute("resultList");
    SellerDto seller = (SellerDto) request.getAttribute("seller");
%>
<body>
<div class="wrap">
    <%@include file="../layout/header.jsp" %>

    <div class="bookWrapper">

        <div class="adminInfoBox">
            <span><%=seller.getName()%></span>님의 <span><%=seller.getStore_name()%></span><br>
            <button type="button" onclick= "myPagePost()">개인정보 수정</button>
        </div>

        <div class="aBox">
            <ul>
                <li><a href="/updateBook.do" onclick="register()">상품등록</a></li>
                <li>|</li>
                <li><a href="/manageDelivery.do">배송관리</a></li>
                <li>|</li>
                <li><a href="/chart.do">실적통계</a></li>
            </ul>
        </div>

        <span class="title">내가 등록한 책</span><br>
        <div class="lineBox">
        </div>

        <div class="contentBox">
            <div class="selectCategory">
                <select id="categorySelect" onchange="changeBooks()">
                    <option value="전체">전체</option>
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

                <input type="text" name="keyword" id="keyword" onchange="inputTextCheck()"
                       placeholder="키워드를 입력하세요.">
                <button type="button" id="searchBtn" onclick="searchButton()">search</button>
            </div>
            <div class="orderByBox">
                <button type="button" id="orderByBtn" onclick="salesButton()">* 판매량순</button>
            </div>

            <div class="tableBox">
                <%
                if(list.size() == 0){
                %>
                    <div class="noBook">등록된 책이 없습니다.</div>
                <%
                }
                else{
                %>
                <table id="maintable">
                    <%
                        for (RegisteredBookDto dto : list) {
                    %>
                    <tr>
                        <td><img id="bookImg" src="<%= dto.getImage_url()%>"></td>
                        <td><%= dto.getTitle()%>
                        </td>
                        <td>
                            <%= dto.getOrder_count()%>/<%= dto.getBook_count()%>
                        </td>
                        <td>
                            <button type="button" name="editBtn" id="editBtn"
                                    value="<%= dto.getRegistered_book_id()%>"
                                    onclick="editButton(<%= dto.getRegistered_book_id()%>)">edit
                            </button>
                        </td>
                        <td>
                            <button type="button" name="cancelBtn" id="cancelBtn"
                                    value="<%= dto.getRegistered_book_id()%>"
                                    onclick="cancelBookButton(<%= dto.getRegistered_book_id()%>)">cancel
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <%
                    }
                %>
            </div>
        </div>
    </div>


    <%@include file="../layout/footer.jsp" %>

</div>
<script type="text/javascript">
  document.querySelector('#keyword').addEventListener('keyup', (e) => {
    if (e.keyCode === 13) {
      searchButton();
    } else if (document.getElementById('keyword').value === '') {

      var sel = document.getElementById('categorySelect');
      var val = sel.options[sel.selectedIndex].value;

      var jsonData = {"category": val, "sellStatus": 1};

      getBooks("category.do", jsonData);
    }
  });

</script>

</body>
</html>
