<%@ page import="bossbabies.com.a.dto.mypage.MyPageDto" %>
<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.mypage.OrderedBookDto" %>
<%@ page import="bossbabies.com.a.dto.mypage.LikedBookDto" %>
<%@ page import="bossbabies.com.a.dto.mypage.MyPageReviewDto" %>
<%--
  Created by IntelliJ IDEA.
  User: BTC-N01
    Date: 2022-07-18
    Time: 오후 12:01
    To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public String dateFormat(String str) { // 글이 길 때 ...으로 줄임
        String res = "";
        res = str.substring(0, 10) + " " + str.substring(11, 19);
        return res;
    }
%>

<%
    MyPageDto member = (MyPageDto) request.getAttribute("member");
    List<OrderedBookDto> ol = (List<OrderedBookDto>) request.getAttribute("orderList");
    List<LikedBookDto> ll = (List<LikedBookDto>) request.getAttribute("likeList");
    List<MyPageReviewDto> rl = (List<MyPageReviewDto>) request.getAttribute("reviewList");
%>
<html>
<head>
    <title>mypage</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css'>

    <style>
        th {
            background-color: #3CAE76;
            color: #f8f8f8;
        }
    </style>
</head>
<body>
<h1>마이페이지</h1>

<div class="card border-success mb-3" style="text-align: center; width: 20%; margin-left:40%; margin-right:40%;">
    <div class="card-header">쇼핑하기 좋은 날이에요!</div>
    <div class="card-body">
        <h4 class="card-title" style="text-align: center"><%=member.getName()%> 님</h4>
        <p>
            <button type="button" class="btn btn-outline-secondary">개인정보수정</button>
        </p>
    </div>
</div>

<table class="table table-hover align-middle"
       style="text-align: center; width: 70%; margin-left:15%; margin-right:15%;">
    <tr>
        <th colspan="5">구매한 상품</th>
    </tr>
    <%
        for (int i = 0; i < ol.size(); i++) {
            OrderedBookDto orderBook = ol.get(i);
            if (orderBook.isCancelStatus()) continue;
    %>
    <tr>
        <td><img class="shadow-lg" src="<%=orderBook.getImageUrl()%>" alt="책책책"></td>
        <td class="align-middle"><a
                href="getDetailedBook.do?registered_book_id=<%=orderBook.getBookId()%>"><%=orderBook.getTitle()%>
        </a></td>
        <td class="align-middle"><%=orderBook.getPrice()%>원
        </td>
        <td class="align-middle"><%=dateFormat(orderBook.getOrderDate().toString())%>
        </td>
        <%
            if (orderBook.isDeliveryStatus()) {
        %>
        <td class="align-middle">
            <button class="btn btn-success"
                    onclick="location.href='writeReview.do?bookId=<%=orderBook.getBookId()%>&memberId=<%=member.getMemberId()%>'">
                리뷰달기
            </button>
        </td>
        <%} else {%>
        <td class="align-middle">
            <button type="button" class="btn btn-success"
                    onclick="location.href='cancelOrder.do?orderId=<%=orderBook.getOrderId()%>&memberId=<%=member.getMemberId()%>'">
                취소
            </button>
        </td>
        <%}%>
    </tr>
    <%
        }
    %>
    <tr>
        <th colspan="5">좋아요한 상품</th>
    </tr>
    <%
        for (int i = 0; i < ll.size(); i++) {
            LikedBookDto likeBook = ll.get(i);
    %>
    <tr>
        <td><img class="shadow-lg" src="<%=likeBook.getImageUrl()%>" alt="책책책"></td>
        <td colspan="2" class="align-middle"><a
                href="getDetailedBook.do?registered_book_id=<%=likeBook.getBookId()%>"><%=likeBook.getTitle()%>
        </a></td>
        <td class="align-middle"><%=likeBook.getPrice()%>원
        </td>
        <td class="align-middle">
            <button class="btn btn-success"
                    onclick="location.href='deleteLike.do?likeId=<%=likeBook.getLikeId()%>&memberId=<%=member.getMemberId()%>'">
                취소
            </button>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <th colspan="5">내가 작성한 리뷰</th>
    </tr>
    <%
        for (int i = 0; i < rl.size(); i++) {
            MyPageReviewDto review = rl.get(i);
    %>
    <tr>
        <td rowspan="3"><img class="shadow-lg" src="<%=review.getImageUrl()%>" alt="책책책"></td>
        <td colspan="3" class="align-middle"><%=review.getTitle()%></td>
        <td rowspan="3" class="align-middle"><%=dateFormat(review.getReviewDate().toString())%></td>
    </tr>
    <tr>

        <td colspan="3" class="align-middle" style="color: #147B48;"><%=review.getContent()%>
        </td>
    </tr>
    <tr>
        <td colspan="3" class="align-middle"><img src="/resources/images/star.png" alt="별"
                                                  style="text-align: left; width: 20px;"> <%=review.getStar()%>.0
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
