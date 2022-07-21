<%@ page import="bossbabies.com.a.dto.BookDto" %><%--
  Created by IntelliJ IDEA.
  User: BTC-N01
  Date: 2022-07-19
  Time: 오후 3:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    BookDto book = (BookDto)request.getAttribute("book");
    int bookId = Integer.parseInt(request.getParameter("bookId"));
    int memberId = Integer.parseInt(request.getParameter("memberId"));
%>
<html>
<head>
    <title>MZ BOOK: 리뷰 작성</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">

    <style>
        .reviewInputContainer {
            display: flex;
            align-items: center;
            flex-direction: column;
            text-align: center;
            padding: 10px;
            margin-bottom: 20px;
        }
        .starContainer {
            display: flex;
            justify-content: center;
            font-size: 50px;
        }
        .star-rating {
            display: flex;
            flex-direction: row-reverse;
            font-size: 1.5em;
            justify-content: space-around;
            padding: 0 .2em;
            text-align: center;
            width: 5em;
        }

        .star-rating input {
            display: none;
        }

        .star-rating label {
            -webkit-text-fill-color: #AFAFAF;
            cursor: pointer;
        }

        .star-rating :checked ~ label {
            -webkit-text-fill-color: gold;
        }

        .star-rating label:hover,
        .star-rating label:hover ~ label {
            -webkit-text-fill-color: #fff58c;
        }
        .starContainer {
            display: flex;
            justify-content: center;
            font-size: 50px;
        }
        .starText {
            color: #fc0;
        }

    </style>

</head>
<body>

<%@include file = "layout/header.jsp" %>

<form action="writeReviewAf.do" method="post">
    <input type="hidden" name="bookId" value="<%=bookId%>">
    <input type="hidden" name="memberId" value="<%=memberId%>">

    <div style="text-align: center; margin-top: 100px;">
        <div style="margin-bottom: 30px;">
            <img class="shadow-lg" src="<%=book.getImage_url()%>" alt="책책책">
        </div>
        <div style="font-weight: bold;">
            <%=book.getTitle()%>
        </div>
        <div class="form-group" style="width: 30%; margin: auto";>
            <label for="exampleTextarea" class="form-label mt-4">리뷰 작성</label>
            <textarea class="form-control" id="exampleTextarea" name="content" rows="7" cols="50"
                      placeholder="최소 10자 이상 입력해주세요."></textarea>
        </div>
        <div class="reviewInputContainer">
            <form name="insertReviewForm">
                <div class="starContainer">
                    <div class="star-rating">
                        <input type="radio" id="5-stars" name="star" value="5" style="opacity: 0"/>
                        <label for="5-stars" class="starText">&#9733;</label>
                        <input type="radio" id="4-stars" name="star" value="4" style="opacity: 0"/>
                        <label for="4-stars" class="starText">&#9733;</label>
                        <input type="radio" id="3-stars" name="star" value="3" style="opacity: 0"/>
                        <label for="3-stars" class="starText">&#9733;</label>
                        <input type="radio" id="2-stars" name="star" value="2" style="opacity: 0"/>
                        <label for="2-stars" class="starText">&#9733;</label>
                        <input type="radio" id="1-star" name="star" value="1" style="opacity: 0"/>
                        <label for="1-star" class="starText">&#9733;</label>
                    </div>
                </div>

            </form>
        </div>
        <button type="submit" class="btn btn-success" style="margin-top: 10px; margin-bottom: 50px;">작성하기</button>
    </div>
</form>

<%@include file = "layout/footer.jsp" %>
</body>
</html>
