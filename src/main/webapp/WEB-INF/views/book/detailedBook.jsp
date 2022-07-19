<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    RegisteredBookDto registeredBook = (RegisteredBookDto) request.getAttribute("registered_book");
    BookDto book = (BookDto) request.getAttribute("book");
    Boolean likeStatus = (Boolean) request.getAttribute("likeStatus");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <h2>이미지</h2>
    <img src="<%=book.getImage_url()%>" width="400px">
</div>

<div>
    <h2>구매 정보</h2>
    <div>
        책이름 : <%=book.getTitle() %>
    </div>

    <div>
        가격 : <%=book.getPrice() %><br>
        할인율 : <%=registeredBook.getDiscount_rate()%>
    </div>

    <div>
        별점 :
    </div>

    <div>
        개수 + -<br>
        <button type="button" >구매하기</button>
    </div>

    <div>
        <%=likeStatus.toString() %>
        <button type="button" onclick="setLike()">좋아요</button>
    </div>
</div>

<div>
    <h2>상세 정보</h2>
    isbn : <%=book.getIsbn()%><br>
    author : <%=book.getAuthor()%><br>
    description : <%=book.getDescription()%><br>
    category : <%=book.getCategory()%><br>
    publish date : <%=book.getPubdate()%><br>
    publisher : <%=book.getPublisher()%><br>
</div>

<div>
    <h2>리뷰</h2>
</div>

<script type="text/javascript">

function setLike(){
    //ajax
}

</script>
</body>
</html>
