<%--
  Created by IntelliJ IDEA.
  User: BTC-N20
  Date: 2022-07-19
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--직접추가--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<link rel="stylesheet" href="../css/header.css">
<h1>저는 김혜연 바보 똥입니다</h1>
<div id="wrap">
    <header id="header">
        <div class="header_top">
            <div class="header_top_cont">
                <ul class="top_member_box">
                    <li>
                        <a href="login.do">LOGIN</a>
                        <span class="txt_bar"></span>
                    </li>
                    <li>
                        <a href="join.do">JOIN</a>
                        <span class="txt_bar"></span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="header_bottom header_search">
            <div class="header_search_cont">
                <div class="h1_logo">
                    <a href="">MZ BOOK</a>
                    <%--image 넣을 예정--%>
                    <%--                    <img src="" title="로고 이미지">--%>
                </div>
            </div>
        </div>
    </header>
    <main style="background-color: #555555">
        <div class="sub_content">
            <div class="main_visual">
                <div class="slider-wrap">

                    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="image/banner1.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="image/banner2.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block w-100" src="image/banner3.jpg" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                           data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                           data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>