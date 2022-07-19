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
</head>
<body>

<div class="imgBox">
    <h2>이미지</h2>
    <img src="<%=book.getImage_url()%>" width="400px">
</div>

<div class="orderBox">
    <h2>구매 정보</h2>
    <div>
        책이름 : <%=book.getTitle() %>
    </div>

    <div>
        가격 : <%=book.getPrice() %><br>
        할인율 : <%=registeredBook.getDiscount_rate()%>
    </div>

    <div>
        별점 : <%=starAvg %>
    </div>

    <div>
        <button type="button" onclick="makeOrder()">구매하기</button>
    </div>

    <div>
        <span id="likestatus"><%=likeStatus.toString() %></span>
        <button type="button" onclick="setLike()">좋아요</button>
        <button type="button" onclick="cancelLikes()">좋아요취소</button>
    </div>
</div>

<div class="infoBox">
    <h2>상세 정보</h2>
    isbn : <%=book.getIsbn()%><br>
    author : <%=book.getAuthor()%><br>
    description : <%=book.getDescription()%><br>
    category : <%=book.getCategory()%><br>
    publish date : <%=book.getPubdate()%><br>
    publisher : <%=book.getPublisher()%><br>
</div>

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


<script type="text/javascript">

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
                $("#likestatus").text("true");
            }
            else{
                console.log(data);
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
                $("#likestatus").text("false");
            }
            else{
                console.log(data);
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
