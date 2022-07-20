<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main id="main">
    <div class="main_content">
        <div class="main_goods_cont">
            <div class="goods_list">
                <div class="goods_list_tit">
                    <div class="goods_list_title">
                        <p class="bp-list-title">
                            <span>인기 도서</span>
                        </p>
                        <p class="bp-list-description">내 책을 처음으로 마주하는 공간</p>
                        <p class="themeText_20" style="margin:5px 0 20px 0"></p>
                    </div>
                </div>
                <div class="slider">
                    <c:forEach var="book" items="${popularBookInfoDtos}">
                        <div align="center" class="book-cover">
                            <a href="getDetailedBook.do?registered_book_id=${book.registered_book_id}">
                                <img src="${book.image_url}" style="border: 2px solid #3CAE76; padding: 5px;">
                            </a>
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
                    <c:forEach var="bookInfo" items="${bookInfoDtos}">
                        <div align="center" class="book-cover">
                            <a href="getDetailedBook.do?registered_book_id=${bookInfo.registered_book_id}"><img
                                    src="${bookInfo.image_url}" style="border: 2px solid #3CAE76; padding: 5px;"></a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>