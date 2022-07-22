<%@ page import="java.util.Map" %>
<%@ page import="bossbabies.com.a.dto.RegisteredBookDto" %>
<%@ page import="bossbabies.com.a.dto.BookDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> userInfo = (Map<String, String>) request.getAttribute("userInfo");
    RegisteredBookDto registeredBook = (RegisteredBookDto) request.getAttribute("registeredBook");
    BookDto book = (BookDto) request.getAttribute("book");
    String storeName = (String) request.getAttribute("storeName");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <title>Title</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/font.css">

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/checkOrder.css">
</head>
<body>
<%@include file = "../layout/header.jsp" %>

<div class="checkOrderBox">

    <span class="title">도서 정보</span><br>
    <div class="lineBox"></div>

    <div class="orderedBookInfoBox">
        <div class="imgBox">
            <img src="<%=registeredBook.getImage_url()%>" width="150px">
        </div>
        <div class="bookInfoBox">
            <div class="storeName">[서점이름]<%=storeName%></div>
            <div class="bookTitle"><%=book.getTitle()%></div>
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
            <br>
            <span>수량 : 1개 / 배송 : 무료배송</span>
        </div>
    </div>

    <span class="title">주문자 정보</span><br>
    <div class="lineBox"></div>

    <div class="userInfoBox">
        <div class="addressCheckBox">
            <input type="radio" id="defaultAddress" class="optionRadio" name="addressOption" value="default" checked><label for="defaultAddress">기본 배송지</label>
            <input type="radio" id="newAddress" class="optionRadio" name="addressOption" value="new" ><label for="newAddress">새로운 배송지</label>
        </div>
        <div class="inputs">
            주문자 이름 <input type="text" class="input" id="name" name="name" value="<%=userInfo.get("name")%>">
        </div>
        <div class="inputs">
            핸드폰 번호 <input type="text" class="input" id="phone" name="phone" value="<%=userInfo.get("phone")%>">
        </div>
        <div class="inputs">
            주소 <input type="text" class="input" id="address" name="address" value="<%=userInfo.get("address")%>">
        </div>

        <div class="requestBox">
            배송 요청사항 <input class="input" type="text" id="request" name="request">
        </div>
    </div>

    <span class="title">결제 방법</span><br>
    <div class="lineBox"></div>

    <div class="paymentBox">
        <button class="paymentBtn">L.PAY 간편결제</button>
        <button class="paymentBtn current">신용카드</button>
        <button class="paymentBtn">무통장입금</button>
        <button class="paymentBtn">휴대폰결제</button>
        <button class="paymentBtn">카카오페이</button>
        <button class="paymentBtn">네이버페이</button>
    </div>
    <div class="buttonBox">
        <button type="button" class="orderBtn" onclick="makeOrder()">구매하기</button>
    </div>

</div>

<%@include file = "../layout/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    window.onload = function(){
        document.getElementById("address").addEventListener("click", function(){ //주소입력칸을 클릭하면
            //카카오 지도 발생
            new daum.Postcode({
                oncomplete: function(data) { //선택시 입력값 세팅
                    document.getElementById("address").value = "";
                    document.getElementById("address").value = data.address; // 주소 넣기
                }
            }).open();
        });
    }
    $("input[name='addressOption']:radio").change(function () {
        let addressOption = this.value;
        let name = document.getElementById('name');
        let phone = document.getElementById('phone');
        let address = document.getElementById('address');

        if(addressOption == "default"){
            name.value = "<%=userInfo.get("name")%>";
            phone.value = "<%=userInfo.get("phone")%>";
            address.value = "<%=userInfo.get("address")%>";
        }
        else{
            name.value = "";
            phone.value = "";
            address.value = "";
        }
    });
    $('.paymentBox button').click(function(){
        $('.paymentBox button').removeClass('current');
        $(this).addClass('current');
    });
    function makeOrder(){
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
</script>
</body>
</html>
