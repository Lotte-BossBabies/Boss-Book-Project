<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.main.RegisteredBookInfoDto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<RegisteredBookInfoDto> byCategoryList = (List<RegisteredBookInfoDto>) request.getAttribute("byCategoryList");
//    String cateName = request.getParameter("cateName");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 도서 스토어</title>
    <%--직접추가--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="/resources/css/font.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/bookstore.css"/>">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
<%@ include file="../layout/header.jsp" %>

<div id="bookstore">
    <div id="container">
        <div class="content">
            <div class="bookstore_category_top">
                <div class="bookstore_category">
                    <div class="bookstore_category_title">일반 도서</div>
                </div>
            </div>

            <div class="goods_list_item">
                <div class="search-bookname">
                    <input type="text" name="keyword" id="search-title"
                           placeholder="책 제목을 검색하세요.">
                    <button id="search-btn" type="button">검색</button>
                </div>
                <div class="list_item_category">
                    <ul class="children-boldn kdm-goods-list">
                        <li><a class="cate_btn" href="?cateName=all"><span class="category_name"
                                                                                      style="font-weight: normal; font-size:14px;">전체</span></a>
                        </li>
                        <li><a class="cate_btn" href="?cateName=문학"><span class="category_name"
                                                                                     style="font-weight: normal; font-size:14px;">문학</span></a>
                        </li>
                        <li><a class="cate_btn" href="?cateName=사회과학"><span class="category_name"
                                                                                        style="font-weight: normal; font-size:14px;">사회과학</span></a>
                        </li>
                        <li><a class="cate_btn" href="?cateName=경제경영"><span
                                style="font-weight: normal; font-size:14px;">경제경영</span></a></li>
                        <li><a class="cate_btn" href="?cateName=인문"><span
                                style="font-weight: normal; font-size:14px;">인문</span></a>
                        </li>
                        <li><a class="cate_btn" href="?cateName=어린이/청소년"><span
                                style="font-weight: normal; font-size:14px;">어린이/청소년</span></a></li>
                        <li><a class="cate_btn" href="?cateName=전문서적/교재"><span
                                style="font-weight: normal; font-size:14px;">전문서적/교재</span></a></li>
                        <li><a class="cate_btn" href="?cateName=기타"><span
                                style="font-weight: normal; font-size:14px;">기타</span></a>
                        </li>
                    </ul>
                    <%--chd category 추가--%>
                </div>

                <div class="goods_list">
                    <%
                        if (byCategoryList.size() == 0) {
                    %>
                    <div class="book-empty" align="center" style="font-size: 15pt;margin-top: 70px;">등록된 책이 없습니다.</div>
                    <%
                        }%>
                    <div class="goods_list_cont">
                        <div class="item_gallery_type">
                            <ul class="search-ul">
                                <%
                                    if (byCategoryList.size() != 0) {
                                %>
                                <c:forEach var="regiBookInfo" items="${byCategoryList}">
                                    <li style="width: 25%">
                                        <div class="item_cont">
                                            <div class="store-name">
                                                <img src="/resources/images/signboard.png">
                                                <span>${regiBookInfo.store_name}</span>
                                            </div>
                                            <div class="item_photo_box">
                                                <a href="getDetailedBook.do?registered_book_id=${regiBookInfo.registered_book_id}">
                                                    <img width="166"
                                                         style="border: 2px solid #3CAE76; padding: 5px;"
                                                         src=${regiBookInfo.image_url}>
                                                </a>
                                            </div>
                                            <div class="item_info_cont">
                                                <div class="item_tit_box">
                                                    <a href="getDetailedBook.do?registered_book_id=${regiBookInfo.registered_book_id}">
                                                        <strong class="item_name">${regiBookInfo.title}</strong>
                                                    </a>
                                                </div>
                                                <div class="bp-writer">
                                                    <span><${regiBookInfo.author}></span>
                                                </div>
                                                <div class="item_money_box">
                                                    <strong class="item_price"><span>${regiBookInfo.price}원</span></strong>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                                <%
                                    }
                                %>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<br>
<%@ include file="../layout/footer.jsp" %>
<script>
    $(document).ready(function () {

        $('#search-btn').click(function () {
            var search = $('#search-title').val();
            // alert(search);

            $.ajax({
                url: 'searchRegisteredBook.do',
                type: 'GET',
                data: {'search': search},
                contentType: 'application:json; charset=UTF-8',
                dataType: 'json',
                success: function (data) {
                    var str = "";
                    $(".search-ul").remove();
                    $(".book-empty").remove();

                    str += '<ul class="search-ul">'

                    $.each(data, function (i) {
                        str += '<li style="width: 25%">' +
                            '<div class="item_cont">' +
                            '<div class="store-name">' +
                                                '<img src="/resources/images/signboard.png">' +
                                                '<span>' + data[i].store_name+'</span>' +
                                            '</div>' +
                            '<div class="item_photo_box">' +
                            '<a href="getDetailedBook.do?registered_book_id=' + data[i].registered_book_id + '">' +
                            '<img width="166"' +
                            ' style="border: 2px solid #3CAE76; padding: 5px;"' +
                            ' src=' + data[i].image_url + '>' +
                            '</a>' +
                            '</div>' +
                            '<div class="item_info_cont">' +
                            '<div class="item_tit_box">' +
                            '<a href="getDetailedBook.do?registered_book_id=' + data[i].registered_book_id + '">' +
                            '<strong class="item_name">' + data[i].title + '</strong>' +
                            '</a>' +
                            '</div>' +
                            '<div class="bp-writer">' +
                            '<span><' + data[i].author + '></span>' +
                            '</div>' +
                            '<div class="item_money_box">' +
                            '<strong class="item_price"><span>' + data[i].price + '원</span></strong>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</li>'
                    });
                    str += '</ul>'

                    $(".item_gallery_type").append(str);
                },
                error: function (e) {
                    alert("error");
                }
            });
        });
    });

</script>

</body>
</html>
