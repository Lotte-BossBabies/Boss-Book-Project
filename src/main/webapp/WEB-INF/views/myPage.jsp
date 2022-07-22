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
    public String dateFormat(String str) {
        String res = str.substring(0, 4) + "년 " + str.substring(5, 7) + "월 "
                + str.substring(8, 10) + "일 " + str.substring(11, 19);
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

    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>MZ BOOK: 마이페이지</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/font.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">

    <style>
        h2 {
            color: #147B48;
            margin-left: 15%;
            margin-bottom: 15px;
        }

        img {
            width: 150px;
        }

        .flex-container {
            display: flex;
        }

        .review-content {
            margin-top: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<%@include file = "layout/header.jsp" %>

<div class="card border-success mb-3" style="text-align: center; width: 70%; margin-left:15%; margin-top: 100px;">
    <div class="card-header">♥쇼핑하기 좋은 날이에요!♥</div>
    <div class="card-body">
        <h4 class="card-title" style="margin: 10px;"><img src="/resources/images/happiness.png" alt="별"
                                                          style="text-align: left; width: 30px;">&nbsp;<%=member.getName()%> 님</h4>
        <p>
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='updateUser.do'">개인정보 수정</button>
        </p>
    </div>
</div>

<div>
    <h2 style="margin-top: 100px;">구매한 상품</h2>
    <table class="table table-hover align-middle"
           style="text-align: center; width: 70%; margin-left:15%;">
        <%
            if(ol.isEmpty()) {
        %>
            <tr>
                <td>구매한 상품이 없습니다!</td>
            </tr>
        <%
            }
            for (int i = 0; i < ol.size(); i++) {
                OrderedBookDto orderBook = ol.get(i);
                if (orderBook.isCancelStatus()) continue;
        %>
        <tr>
            <td><img class="shadow-lg" src="<%=orderBook.getImageUrl()%>" alt="책책책"></td>
            <td class="align-middle" style="width: 35%"><a class="text-success"
                    href="getDetailedBook.do?registered_book_id=<%=orderBook.getBookId()%>"><%=orderBook.getTitle()%>
            </a></td>
            <td class="align-middle" style="width: 10%"><%=orderBook.getPrice()%>원
            </td>
            <td class="align-middle" style="width: 20%"><%=dateFormat(orderBook.getOrderDate().toString())%>
            </td>
            <%
                if (orderBook.isDeliveryStatus()) {
            %>
            <td class="align-middle" style="width: 15%">
                <button class="btn btn-outline-success"
                        onclick="location.href='writeReview.do?bookId=<%=orderBook.getBookId()%>&memberId=<%=member.getMemberId()%>'">
                    <img src="/resources/images/document.png" alt="리뷰"
                         style="text-align: left; width: 20px;">
                    리뷰 작성
                </button>
            </td>
            <%} else {%>
            <td class="align-middle" style="width: 15%">
                <button type="button" class="btn btn-outline-success"
                        onclick="cancelBtn(); location.href='cancelOrder.do?orderId=<%=orderBook.getOrderId()%>';">
                    주문 취소
                </button>
            </td>
            <%}%>
        </tr>
        <%
            }
        %>
    </table>
</div>

<div>
    <h2 style="margin-top: 100px;">좋아요한 상품</h2>
    <table class="table table-hover align-middle"
           style="text-align: center; width: 70%; margin-left:15%;">
        <%
            if(ll.isEmpty()) {
        %>
        <tr>
            <td>좋아요한 상품이 없습니다!</td>
        </tr>
        <%
            }
            for (int i = 0; i < ll.size(); i++) {
                LikedBookDto likeBook = ll.get(i);
        %>
        <tr>
            <td><img class="shadow-lg" src="<%=likeBook.getImageUrl()%>" alt="책책책"></td>
            <td colspan="2" class="align-middle" style="width: 45%"><a class="text-success"
                    href="getDetailedBook.do?registered_book_id=<%=likeBook.getBookId()%>"><%=likeBook.getTitle()%>
            </a></td>
            <td class="align-middle" style="width: 20%"><%=likeBook.getPrice()%>원
            </td>
            <td class="align-middle" style="width: 15%">
                <button class="btn btn-outline-success"
                        onclick="location.href='deleteLike.do?likeId=<%=likeBook.getLikeId()%>'">
                    취소
                </button>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<div>
    <h2 style="margin-top: 100px;">나의 리뷰</h2>
    <table class="table table-hover align-middle"
           style="text-align: center; width: 70%; margin-left:15%; margin-bottom: 70px;">
        <%
            if(rl.isEmpty()) {
        %>
        <tr>
            <td>작성한 리뷰가 없습니다!</td>
        </tr>
        <%
            }
            for (int i = 0; i < rl.size(); i++) {
                MyPageReviewDto review = rl.get(i);
        %>
        <tr>
            <td class="align-middle">
                <div class="flex-container">
                    <div style="margin-left: 40px; margin-right: 40px;"><img class="shadow-lg"
                                                                             src="<%=review.getImageUrl()%>" alt="책책책">
                    </div>
                    <div style="  width: 60%; margin-right: 5%;margin-top: 25px; margin-left: 5%;">
                        <div class="review-content" style="font-weight: bold"><%=review.getTitle()%>
                        </div>
                        <div class="review-content" style="font-size: 15px; color: #555555">
                            <%=dateFormat(review.getReviewDate().toString())%>
                        </div>
                        <div class="review-content"><img src="/resources/images/star.png" alt="별"
                                                         style="text-align: left; width: 20px;"> <%=review.getStar()%>
                        </div class="review-content">
                        <div class="card border-success mb-3">
                            <div class="card-body">
                                <p class="card-text"><%=review.getContent()%>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div style=" margin-top: 100px;">
                        <button class="btn btn-outline-success"
                                onclick="deleteBtn(); location.href='deleteReview.do?reviewId=<%=review.getReviewId()%>';">
                            삭제
                        </button>
                    </div>
                </div>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

<%@include file = "layout/footer.jsp" %>

<script>
    function cancelBtn(){
        alert("주문이 취소되었습니다.");
    }
    function deleteBtn(){
        alert("리뷰가 삭제되었습니다.");
    }
</script>
</body>
</html>
