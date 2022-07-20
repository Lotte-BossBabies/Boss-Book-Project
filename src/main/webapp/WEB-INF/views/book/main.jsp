<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.BookDto" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<BookDto> bookdtos = (List<BookDto>) request.getAttribute("bookDtos");
%>
<html>
<head>
    <title>Title</title>
    <%--직접추가--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css"/>

    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/banner.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">

    <script>
        $(document).ready(function () {
            $('.slider').slick({
                autoplay: true,
                autoplaySpeed: 3000,
                slidesToShow: 5,
                slidesToScroll: 1,
                responsive: [
                    {
                        breakpoint: 768,
                        settings: {
                            slidesToShow: 3,
                            arrows: false,
                        }
                    },
                    {
                        breakpoint: 600,
                        settings: {
                            slidesToShow: 1,
                            arrows: false,
                        }
                    }
                ]
            });
        });
    </script>

</head>
<body>
<div id="wrap">
    <header id="header_warp">
        <div id="header">
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
                        <%--image 넣을 예정--%>
                        <img src="resources/images/logo.png" title="로고 이미지">
                    </div>
                </div>
            </div>
            <div class="header_gnb">
                <div class="gnb">
                    <div class="gnb_menu_box">
                        <ul class="depth0 gnb_menu0"
                            style="color: rgb(51, 51, 51);" <%--style="overflow: visible; height: 100%;"--%>>
                            <li>
                                <a href="">ABOUT</a>
                            </li>
                            <li>
                                <a href="">가이드</a>
                            </li>
                            <li>
                                <a href="">서점</a>
                            </li>
                            <li>
                                <a href="">작가마켓</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div id="container">
        <div id="contents">
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
        </div>
    </div>
    <main id="main">
        <div class="main_content">
            <div class="main_goods_cont">
                <div class="goods_list">
                    <div class="goods_list_tit">
                        <div class="goods_list_title">
                            <p class="bp-list-title">
                                <span>추천 도서</span>
                            </p>
                            <p class="bp-list-description">내 책을 처음으로 마주하는 공간</p>
                            <p class="themeText_20" style="margin:5px 0 20px 0"></p>
                        </div>
                    </div>
                    <div class="slider">
                        <c:forEach var="book" items="${bookDtos}">
                            <div align="center" class="book-cover">
                                <img src="${book.image_url}" style="border: 2px solid #3CAE76; padding: 5px;">
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <hr>
                <div class="goods_list">
                    <div class="goods_list_tit">
                        <div class="goods_list_title">
                            <p class="bp-list-title">
                                <span>작가 마켓</span>
                            </p>
                            <p class="bp-list-description">합리적인 가격으로 이용하는 엠제트 출판 서비스</p>
                            <p class="themeText_20" style="margin:5px 0 20px 0"></p>
                        </div>
                    </div>
                    <div class="slider">
                        <div><img src="https://bimage.interpark.com/partner/goods_image/4/4/4/7/354514447s.jpg" alt="">
                        </div>
                        <div><img src="https://bimage.interpark.com/partner/goods_image/7/5/5/2/354337552s.jpg" alt="">
                        </div>
                        <div><img src="https://bimage.interpark.com/partner/goods_image/7/5/4/2/354337542s.jpg" alt="">
                        </div>
                        <div><img src="https://bimage.interpark.com/partner/goods_image/2/2/1/4/354852214s.jpg" alt="">
                        </div>
                        <div><img src="https://bimage.interpark.com/partner/goods_image/0/1/3/6/354460136s.jpg" alt="">
                        </div>
                        <div><img src="https://bimage.interpark.com/partner/goods_image/2/2/5/6/354552256s.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <br>
    <footer id="footer" class="wideArea withSeller el">
        <div class="footerTopMenu innerContent">
            <ul>
                <li>
                    <a>MZ BOOK 소개</a>
                </li>
                <li>
                    <a>지점안내</a>
                </li>
                <li>
                    <a>이용약관</a>
                </li>
                <li>
                    <a>전자금융거래약관</a>
                </li>
                <li>
                    <a>개인정보처리방침</a>
                </li>
                <li>
                    <a>청소년보호방침</a>
                </li>
                <li>
                    <a>입점상담</a>
                </li>
            </ul>
        </div>
        <hr>
        <div class="companyInfo innerContent">
            <h2 class="logoArea el">
                <img src="resources/images/logo.png">
            </h2>
            <div class="infoWrapper">
                <div class="company">
                    <h3>보스베이비 주식회사</h3>
                    <ul>
                        <li>대표이사: 천예원</li>
                        <li>주소: 서울특별시 송파구 롯데타워</li>
                        <li>사업자등록번호: 123-45-6789</li>
                    </ul>
                    <h4>롯데쇼핑 e커머스 사업부 보스베이비</h4>
                    <p>고객님의 안전거래를 위해 현금 등으로 결제 시 결제금액 전액에 대해 <br>소비자 피해 방지 서비스를 이용합니다.</p>
                </div>
                <div class="customer">
                    <h3>고객센터 1234-1004(유료)</h3>
                </div>
            </div>
        </div>
        <hr>
        <div class="footerInfo">
            <p>Copyright © BossBabies. All rights reserved.</p>
        </div>
    </footer>
</div>
</body>
</html>