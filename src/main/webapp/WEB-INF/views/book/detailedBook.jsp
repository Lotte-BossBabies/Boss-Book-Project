<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="bossbabies.com.a.dto.ReviewDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RegisteredBookDto registeredBook = (RegisteredBookDto) request.getAttribute("registered_book");
    BookDto book = (BookDto) request.getAttribute("book");
    Boolean likeStatus = (Boolean) request.getAttribute("likeStatus");
    List<ReviewDto> reviewList = (List<ReviewDto>) request.getAttribute("reviewList");
    double starAvg = (double) request.getAttribute("starAvg");
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
        }
        .orderBox{
            grid-column: 2/3;
            grid-row: 1/2;
        }
        .menuBox{
            grid-column: 1/3;
            grid-row: 2/3;
        }

        #bookImg{
            width: 380px;
            margin: auto;
        }

        /* In orderBox */
        #star{
            font-size: 18px;
        }
        #price{
            font-size: 24px;
            color : crimson;
        }
        #originalPrice{
            font-size: 20px;
            text-decoration: line-through;
        }
        #line{
            border-bottom: 1px solid black;
            margin: 10px 0px;
        }
        .priceBox{
            margin: 10px 0px;
        }
        .buttonBox{
            margin: 20px 0px;
        }
        .orderBtn{
            width: 150px;
            height: 50px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 20px;
        }
        .orderBtn:hover{
            border: none;
            background-color: cornflowerblue;
            color: white;
        }
        .likeBtn{
            width: 130px;
            height: 50px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 20px;
        }
        .likeBtn:hover{
            border: none;
            background-color: cornflowerblue;
            color: white;
        }

        /* 메뉴 탭 */
        .menu {
            list-style-type: none;
        }
        .menu > li {
            display: inline-block;
            width: 100px;
            height: 30px;
            border: 1px solid black;
            padding: 20px 20px 10px 20px;
            border-top-left-radius: 12px;
            border-top-right-radius: 12px;
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
            border: 2px solid cornflowerblue;
        }
        .tabContent{
            display: none;
            padding-top: 20px;
            padding-left: 20px;
        }
        .tabContent.current{
            display: inherit;
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

        <div>
            <img src="/resources/images/star.png" width="20px"> <span id="star"><%=starAvg %></span>
        </div>

        <div id="line"></div>

        <div class="priceBox">
            <%
                if(registeredBook.getDiscount_rate() == null){
            %>
                    <span id="price">가격 : <%=book.getPrice() %> 원<br></span>
            <%
                }
                else{
            %>
                    <span id="originalPrice">가격 : <%=book.getPrice() %> 원<br></span>
                    <%
                        double price = (double)book.getPrice();
                        int discountPrice = (int)(price * (100-registeredBook.getDiscount_rate())/100);
                    %>
                    <span id="price">가격 : <%=discountPrice%>원 </span>
            <%
                }
            %>
        </div>

        <div class="buttonBox">
            <button class="likeBtn" id="like" type="button" onclick="setLike()">좋아요</button>
            <button class="likeBtn" id="unlike" type="button" onclick="cancelLikes()">좋아요취소</button>
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
                    <h2>상세 정보</h2>
                    isbn : <%=book.getIsbn()%><br>
                    author : <%=book.getAuthor()%><br>
                    description : <%=book.getDescription()%><br>
                    category : <%=book.getCategory()%><br>
                    publish date : <%=book.getPubdate()%><br>
                    publisher : <%=book.getPublisher()%><br>
                </div>
            </div>
            <div class="tabContent" id="tab2Content">
                <div class="reviewBox">
                    <h2>리뷰</h2>
                    <%
                        for(int i=0; i<reviewList.size(); i++){
                    %>
                    <%=reviewList.get(i).getStar() %> - <%=reviewList.get(i).getContent()%><br>
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
        unlike.style.display = 'block';
    }
    else if(likeStatus == "false"){
        like.style.display = 'block';
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
        var newForm = document.createElement('form');

        newForm.method = 'Get';
        newForm.action = 'makeOrder.do';

        var registered_book_id = document.createElement('input');
        registered_book_id.setAttribute("type", "hidden");
        registered_book_id.setAttribute("name", "registered_book_id");
        registered_book_id.setAttribute("value", <%=registeredBook.getRegistered_book_id() %>);

        newForm.appendChild(registered_book_id);
        document.body.appendChild(newForm);

        newForm.submit();
    }

</script>
</body>
</html>
