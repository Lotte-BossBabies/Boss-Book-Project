<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport"
          content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">
    <title>Insert title here</title>
    <style>
        html, body, div, span, applet, object, iframes, h1, h2, h3, h4, h5, h6,
        p, blockquote, pre, a, abbr, acronym, address, big, quotes, code, del,
        dfn, em, img, ins, kbd, q, s, samp, small, strike, sub, sup, tt, var, u,
        i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table,
        caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
        details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
        output, ruby, section, summary, time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            do: inherit;
            vertical-align: baseline;
        }

        article, aside, details, figcaption, figure, footer, header, hgroup,
        menu, nav, section {
            display: block;
        }

        blockquote, q {
            quotes: none;
        }

        blockquote : before, blockquote : after, q : before, q : after {
            content: '';
            content: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        /*css 초기화*/

        .card {
            height: 400px;
            width: 350px;
            border-radius: 15px;
            display: inline-block;
            margin-top: 30px;
            margin-left: 30px;
            margin-bottom: 30px;
            position: relative;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            overflow: hidden;
        }

        .card-header-1 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/YW.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

        .card:hover .card-header {
            opacity: 0.8;
            height: 100px;
        }

        .card-header-is_closed {
            background-color: #EF5A31;
            color: #FFF;
            font-weight: bold;
            text-align: center;
            float: right;
            margin: 15px 15px 0 0;
            border-radius: 50%;
            font-weight: bold;
            padding: 10px 10px;
            line-height: 20px;
        }

        h1 {
            font-size: 22px;
            font-weight: bold;
        }

        .card-body {
        }

        .card-body-header {
            line-height: 25px;
            margin: 10px 20px 0px 20px;
        }

        .card-body-description {
            opacity: 0;
            color: #757B82;
            line-height: 25px;
            -webkit-transition: .2s ease-in-out; /*사파리&크롬*/
            -moz-transition: .2s ease-in-out; /*파이어폭스*/
            -ms-transition: .2s ease-in-out; /*익스플로러*/
            -o-transition: .2s ease-in-out; /*오페라*/
            transition: .2s ease-in-out;
            overflow: hidden;
            height: 180px;
            margin: 5px 20px;
        }

        .card:hover .card-body-description {
            opacity: 1;
            -webkit-transition: .5s ease-in-out;
            -moz-transition: .5s ease-in-out;
            -ms-transition: .5s ease-in-out;
            -o-transition: .5s ease-in-out;
            transition: .5s ease-in-out;
            overflow: scroll;
        }

        .card-body-hashtag {
            color: #2478FF;
            font-style: italic;
        }

        .card-body-footer {
            position: absolute;
            margin-top: 15px;
            margin-bottom: 6px;
            bottom: 0;
            width: 314px;
            font-size: 14px;
            color: #9FA5A8;
            padding: 0 15px;
        }

        .card-header-2 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/CY.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

        .card-header-3 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/GJ.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

        .card-header-4 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/MJ.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

        .card-header-5 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/ES.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

        .card-header-6 {
            -webkit-transition: 0.5s; /*사파리 & 크롬*/
            -moz-transition: 0.5s; /*파이어폭스*/
            -ms-transition: 0.5s; /*인터넷 익스플로러*/
            -o-transition: 0.5s; /*오페라*/
            transition: 0.5s;
            width: 100%;
            height: 270px;
            border-radius: 15px 15px 0 0;
            background-image: url("../resources/images/HY.png");
            background-size: 100% 280px;
            background-repeat: no-repeat;
        }

    </style>
</head>
<body>
<%--<%@ include file="layout/header.jsp" %>--%>
<div align="center">
    <%-----------------------------------예원-------------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-1">
            <div class="card-header-is_closed">
                <div class="card-header-text"> 조장</div>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>천예원</h1>
                <p class="card-body-hashtag">#고양이집사 #천사예원 #간식요정</p>
            </div>
            <p class="card-body-description">
                97년생<br>
                보스베이비 대표입니다 :)
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
    <%-------------------------------------채영-----------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-2">
            <div class="card-header-is_closed">
                <%--                <div class="card-header-text"> 조장</div>--%>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>안채영</h1>
                <p class="card-body-hashtag">#고양이집사 #욕쟁이할매 #성보라</p>
            </div>
            <p class="card-body-description">
                97년생<br>
                코딩이 안되면 사나워지니까 주의해주세요!
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
    <%---------------------------------------규진---------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-3">
            <div class="card-header-is_closed">
                <%--                <div class="card-header-text"> 조장</div>--%>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>최규진</h1>
                <p class="card-body-hashtag">#DJ #피할수없으면 #즐겨라</p>
            </div>
            <p class="card-body-description">
                97년생<br>
                노래선곡 잘합니다 )(
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
    <%---------------------------------------명주---------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-4">
            <div class="card-header-is_closed">
                <%--                <div class="card-header-text"> 조장</div>--%>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>오명주</h1>
                <p class="card-body-hashtag">#우우 #메리제인 #)(</p>
            </div>
            <p class="card-body-description">
                98년생<br>
                )( !
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
    <%--------------------------------------성은----------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-5">
            <div class="card-header-is_closed">
                <%--                <div class="card-header-text"> 조장</div>--%>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>이성은</h1>
                <p class="card-body-hashtag">#초딩 #개초딩 #잼민이</p>
            </div>
            <p class="card-body-description">
                99년생<br>
                겨우 막내 탈출 )(
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
    <%--------------------------------------혜연----------------------------------------%>
    <div class="card">

        <!-- 카드 헤더 -->
        <div class="card-header-6">
            <div class="card-header-is_closed">
                <%--                <div class="card-header-text"> 조장</div>--%>
            </div>
        </div>

        <!-- 카드 바디 -->
        <div class="card-body">

            <!-- 카드 바디 헤더 -->
            <div class="card-body-header">
                <h1>김혜연</h1>
                <p class="card-body-hashtag">#찐막내 #숨은장인 #풀스택</p>
            </div>
            <p class="card-body-description">
                99년생<br>
                찐 막냉이 )(
            </p>
            <!-- 카드 바디 본문 -->
            <!-- 카드 바디 푸터 -->
            <div class="card-body-footer">
            </div>
        </div>
    </div>
</div>
<%--<%@ include file="layout/footer.jsp" %>--%>
</body>
</html>