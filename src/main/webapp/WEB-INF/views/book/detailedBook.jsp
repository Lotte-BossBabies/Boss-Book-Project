<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="bossbabies.com.a.dto.ReviewDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.ZoneId" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RegisteredBookDto registeredBook = (RegisteredBookDto) request.getAttribute("registered_book");
    BookDto book = (BookDto) request.getAttribute("book");
    Boolean likeStatus = (Boolean) request.getAttribute("likeStatus");
    List<ReviewDto> reviewList = (List<ReviewDto>) request.getAttribute("reviewList");
    double starAvg = (double) request.getAttribute("starAvg");

    String PATTERN_FORMAT = "yyyy년 MM월 dd일";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
            .withZone(ZoneId.systemDefault());
    String publishDate = formatter.format(book.getPubdate());
%>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style type="text/css">

        /* 전체 레이아웃 */
        .detailedBookContainer{
            width: 900px;
            margin: 20px auto;
            display: grid;
            grid-template-columns: 450px 450px;
            grid-template-rows: repeat(2, minmax(400px, auto));
        }
        .imgBox{
            grid-column: 1/2;
            grid-row: 1/2;
            text-align: center;
        }
        .orderBox{
            grid-column: 2/3;
            grid-row: 1/2;
            padding: 10px;
        }
        .menuBox{
            grid-column: 1/3;
            grid-row: 2/3;
        }

        /* In ImgBox */
        #bookImg{
            width: 300px;
        }

        /* In orderBox */
        .star{
            font-size: 18px;
        }
        .basicInfoBox {
            text-align: right;
            padding: 10px;
        }
        .basicInfoTitle{
            font-size: 14px;
            color: #595959;
        }
        .basicInfo{
            font-size: 18px;
            color: #595959;
        }
        .price{
            font-size: 24px;
            color : crimson;
        }
        .pricePoint{
            font-weight: bold;
            font-size: 28px;
        }
        .originalPrice{
            font-size: 20px;
            text-decoration: line-through;
        }
        #line{
            border-bottom: 2px solid black;
            margin: 10px 0px;
        }
        .imgStrBox{
            display: flex;
            align-items: center;
            justify-content: right;
            padding: 10px;
        }
        .imgStrBox > img{
            margin-right: 5px;
        }
        .priceBox{
            margin: 10px 0px;
            text-align: right;
            padding: 10px;
        }
        .btnBox{
            margin: 10px 10px;
            text-align: right;
        }
        .orderBtn{
            display: inline-block;
            width: 280px;
            height: 60px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 20px;
        }
        .orderBtn:hover{
            border: 2px solid cornflowerblue;
            color: cornflowerblue;
        }
        .likeBtn{
            all: unset;
            width: 55px;
            height: 55px;
            margin: 0px 10px;
            cursor: pointer;
        }

        /* In menuBox */
        /* 메뉴 탭 */
        .menu {
            list-style-type: none;
        }
        .menu > li {
            display: inline-block;
            width: 100px;
            height: 30px;
            padding: 20px 20px 10px 20px;
            font-size: 20px;
            cursor: pointer;
        }
        .menu > li a{
            display: block;
            text-decoration: none;
            text-align: center;
            color: black;
        }
        .menu > li a:hover{
            text-decoration: underline;
            font-weight: 700;
            color: cornflowerblue;
        }
        .menu li.current {
            border-bottom: 3px solid cornflowerblue;
        }
        .tabContent{
            display: none;
            padding-top: 20px;
            padding-left: 20px;
        }
        .tabContent.current{
            display: inherit;
        }

        /* 상세 정보 */
        .infoBox{
            margin: 20px auto;
            width: 700px;
            padding: 20px 40px;
            background-color: #f1f7ff;
            border-radius: 10px;
        }
        .contentsBox{
            margin: 30px;
            padding: 30px;
        }
        #contentsTitle{
            font-size: 24px;
            font-weight: 700;
        }
        #contents{
            font-size: 18px;
            margin-top: 10px;
        }

        /* 리뷰 */
        .reviewBox{
            width: 700px;
            margin: 10px auto;
        }
        .reviews{
            background-color: #f1f7ff;
            border-radius: 10px;
            margin: 5px;
            padding: 15px 20px;
        }
        .imgStrBoxInReview{
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .review{
            font-size: 20px;
        }
        .reviewDate{
            font-size: 14px;
            color: #595959;
            margin-top: 5px;
        }
    </style>
</head>
<body>

<div class="detailedBookContainer">
    <div class="imgBox">
        <img id="bookImg" src="<%=book.getImage_url()%>" alt="책 이미지">
    </div>

    <div class="orderBox">
        <div>
            <h2><%=book.getTitle() %></h2>
        </div>

        <div class="imgStrBox">
            <img src="/resources/images/star.png" width="20px"> <span id="star"><%=starAvg %></span>
        </div>

        <div id="line"></div>

        <div class="priceBox">
            <%
                if(registeredBook.getDiscount_rate() == null){
            %>
                <span class="price">가격 : <span class="pricePoint"><%=book.getPrice() %>원</span></span><br>
            <%
                }
                else{
            %>
                <span class="originalPrice">가격 : <%=book.getPrice() %>원</span><br>
                    <%
                        double price = (double)book.getPrice();
                        int discountPrice = (int)(price * (100-registeredBook.getDiscount_rate())/100);
                    %>
                <span class="price">가격 : <span class="pricePoint"><%=discountPrice%>원</span></span><br>
            <%
                }
            %>
        </div>

        <div class="basicInfoBox">
            <span class="basicInfoTitle">배송정보</span>
            <div class="imgStrBox">
                <img src="/resources/images/shipped.png" width="24px"> <span class="basicInfo">무료 배송</span>
            </div>
        </div>

        <div class="basicInfoBox">
            <span class="basicInfoTitle">적립혜택</span>
            <div class="imgStrBox">
                <img src="/resources/images/dollar.png" width="24px"> <span class="basicInfo">L.POINT</span>
            </div>
        </div>

        <div class="btnBox">
            <button class="likeBtn" id="like" type="button" onclick="setLike()"><img src="/resources/images/empty_heart.png" width="55px"></button>
            <button class="likeBtn" id="unlike" type="button" onclick="cancelLikes()"><img src="/resources/images/heart.png" width="55px"></button>
            <button class="orderBtn" type="button" onclick="makeOrder()">구매하기</button>
        </div>

    </div>

    <div class="menuBox">
        <ul class="menu">
            <li class="tabLink current" id="tab1"><a href="#">상세 정보</a></li>
            <li class="tabLink" id="tab2"><a href="#">리뷰</a></li>
        </ul>
        <section class="section">
            <div class="tabContent current" id="tab1Content">
                <div class="infoBox">
                    isbn : <%=book.getIsbn()%><br>
                    저자 : <%=book.getAuthor()%><br>
                    카테고리 : <%=book.getCategory()%><br>
                    발행일 : <%=publishDate%><br>
                    출판사 : <%=book.getPublisher()%><br>
                </div>

                <div class="contentsBox">
                    <span id="contentsTitle">줄거리</span><br><br>
                    <div id="contents"><%=book.getDescription()%></div>
                </div>
            </div>
            <div class="tabContent" id="tab2Content">
                <div class="reviewBox">
                    <div>
                        리뷰 개수 : <%=reviewList.size()%> 개
                    </div>
                    <%
                        for(int i=0; i<reviewList.size(); i++){
                    %>
                    <div class="reviews">
                        <div class="imgStrBoxInReview">
                            <%
                                for(int j=0; j<reviewList.get(i).getStar(); j++){
                            %>
                            <img src="/resources/images/star.png" width="20px">
                            <%
                                }
                            %>
                            <span class="star"><%=reviewList.get(i).getStar() %></span><br>
                        </div>
                        <div class="review"><%=reviewList.get(i).getContent()%></div>
                        <div class="reviewDate">
                            <%=formatter.format(reviewList.get(i).getReview_date())%>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </section>
    </div>
</div>


<script type="text/javascript">

    $('.menu li').click(function(){
        var tabId = $(this).attr('id');

        $('.menu li').removeClass('current');
        $('.tabContent').removeClass('current');

        $(this).addClass('current');
        $("#"+tabId+"Content").addClass('current');
    });

    let likeStatus = "<%=likeStatus.toString() %>";
    let like = document.getElementById("like");
    let unlike = document.getElementById("unlike");
    if(likeStatus == "true"){
        like.style.display = 'none';
        unlike.style.display = 'inline-block';
    }
    else if(likeStatus == "false"){
        like.style.display = 'inline-block';
        unlike.style.display = 'none';
    }

    function setLike(){
        $.ajax ({
            url: "addLikes.do",
            type: "GET",
            data: {
                registered_book_id : "<%=registeredBook.getRegistered_book_id() %>"
            },
            success : function(data) {
                if(data == "true"){
                    console.log(data);
                    likeStatus = data;
                    window.location.reload();
                }
                else{
                    console.log(data);
                    likeStatus = data;
                    window.location.reload();
                }
            },
            error	: function(data) {
                console.log(data);
            }
        });
    }
    function cancelLikes(){
        $.ajax ({
            url: "cancelLikes.do",
            type: "GET",
            data: {
                registered_book_id : "<%=registeredBook.getRegistered_book_id() %>"
            },
            success : function(data) {
                if(data == "true"){
                    console.log(data);
                    likeStatus = data;
                    window.location.reload();
                }
                else{
                    console.log(data);
                    likeStatus = data;
                    window.location.reload();
                }
            },
            error	: function(data) {
                console.log(data);
            }
        });
    }
    function makeOrder(){
        let loginStatus = checkLogin();
        if(loginStatus) {
            let adminStatus = checkAdmin();
            if(!adminStatus) {
                let availableStatus = checkAvailable();
                if(availableStatus){
                    console.log('if');
                    var newForm = document.createElement('form');

                    newForm.method = 'get';
                    newForm.action = 'makeOrder.do';

                    var registered_book_id = document.createElement('input');
                    registered_book_id.setAttribute("type", "hidden");
                    registered_book_id.setAttribute("name", "registered_book_id");
                    registered_book_id.setAttribute("value", <%=registeredBook.getRegistered_book_id() %>);

                    newForm.appendChild(registered_book_id);
                    document.body.appendChild(newForm);

                    newForm.submit();
                }
                else{
                    alert('재고가 부족합니다.');
                }
            }
            else{
                alert('관리자 계정은 책을 구매할 수 없습니다.');
            }
        }
        else{
            alert('로그인이 필요한 서비스입니다.');
            location.href = "login.do";
        }
    }
    function checkLogin(){
        let loginStatus = false;
        $.ajax ({
            url: "checkLogin.do",
            type: "GET",
            success: function(data) {
                likeStatus = data;
            },
            error: function(data) {
                console.log(data);
            }
        });

        return loginStatus;
    }
    function checkAdmin(){
        let adminStatus = true;
        $.ajax ({
            url: "checkAdmin.do",
            type: "GET",
            success: function(data) {
                adminStatus = data;
            },
            error: function(data) {
                console.log(data);
            }
        });
        return adminStatus;
    }
    function checkAvailable(){
        let availableStatus = false;
        $.ajax({
            url: "checkAvailableOrder.do",
            type: "GET",
            data: {
                registered_book_id: "<%=registeredBook.getRegistered_book_id() %>"
            },
            success: function (data) {
                availableStatus = data;
            },
            error: function (data) {
                console.log(data);
            }
        });
        return availableStatus;
    }

</script>
</body>
</html>
