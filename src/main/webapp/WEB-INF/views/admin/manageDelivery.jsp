<%@ page import="bossbabies.com.a.dto.admin.DeliveryDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<DeliveryDto> preDeliveryList = (List<DeliveryDto>)request.getAttribute("preDeliveryList");
    List<DeliveryDto> completedDeliveryList = (List<DeliveryDto>)request.getAttribute("completedDeliveryList");
    int seller_id = (int) request.getAttribute("seller_id");
%>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    
    <title>MZ BOOK: 배송 관리</title>

    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/manageDelivery.css">
    <link rel="stylesheet" href="/resources/css/font.css">

</head>
<body>
<%@include file = "../layout/header.jsp" %>
<div>
    <div class="preDeliveryWrapper">
        <div class="titleBox">
            <a href="adminMain.do?sellStatus=1">돌아가기</a>
        </div>

        <span class="title">배송 전 상품</span><br>
        <div class="lineBox"></div>
        <div class="countBox">총 <span class="deliveryCount"><%=preDeliveryList.size()%></span>개</div>

        <div class="contentBox">
            <%
                for(int i=0; i<preDeliveryList.size(); i++){
                    DeliveryDto curDeliveryDto = preDeliveryList.get(i);
            %>
            <div class="orderBox">
                <div class="imgBox">
                    <img src="<%=curDeliveryDto.getImage_url() %>" alt="책 이미지" width="100px">
                </div>
                <div class="deliveryInfoBox">
                    <div class="title"><%=curDeliveryDto.getTitle()%></div>
                    주문자 : <%=curDeliveryDto.getName() %><br>
                    주소 : <%=curDeliveryDto.getAddress() %><br>
                    전화번호 : <%=curDeliveryDto.getPhone() %><br>
                    주문일 : <%=curDeliveryDto.getOrder_date() %><br>
                </div>
                <div class="buttonBox">
                    <button id="deliveryBtn" type="button" onclick="delivery(<%=curDeliveryDto.getOrder_id()%>)">배송 완료</button>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>

    <div class="completedDeliveryWrapper">
        <span class="title">배송 완료 상품</span><br>
        <div class="lineBox"></div>
        <div class="dateBox">
            <input type="date" class="inputDate" id="startDate"> ~
            <input type="date" class="inputDate" id="endDate">
            <button type="button" onclick="searchOrder()">검색</button>
        </div>

        <div class="countBox">총 <span class="deliveryCount" id="completedDeliveryCount"></span>개</div>

        <div class="contentBox" id="complete">
        </div>
    </div>

</div>
<%@include file = "../layout/footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    function delivery(order_id){
        var newForm = document.createElement('form');

        newForm.method = 'get';
        newForm.action = 'updateDeliveryStatus.do';

        var order_id_input = document.createElement('input');
        order_id_input.setAttribute("type", "hidden");
        order_id_input.setAttribute("name", "order_id");
        order_id_input.setAttribute("value", order_id);

        var seller_id_input = document.createElement('input');
        seller_id_input.setAttribute("type", "hidden");
        seller_id_input.setAttribute("name", "seller_id");
        seller_id_input.setAttribute("value", <%=seller_id%>);

        newForm.appendChild(order_id_input);
        newForm.appendChild(seller_id_input);
        document.body.appendChild(newForm);

        newForm.submit();
    }

    var start_date = document.getElementById('startDate');
    var end_date = document.getElementById('endDate');

    searchOrder();

    function searchOrder(){
        let completedDelivery = document.getElementById('complete');
        completedDelivery.innerHTML = "";

        $.ajax ({
            url: "searchDelivery.do",
            type: "GET",
            data: {
                seller_id : "<%=seller_id%>",
                start_date : start_date.value,
                end_date : end_date.value
            },
            success : function(data) {
                let count = document.getElementById('completedDeliveryCount');
                count.innerHTML = data.length;

                data.forEach(function(item) {
                    let imgBox = document.createElement('div');
                    imgBox.setAttribute('class', 'imgBox');
                    let img = document.createElement('img');
                    img.setAttribute('src', item['image_url']);
                    img.setAttribute('width', '100px');
                    imgBox.appendChild(img);

                    let deliveryInfoBox = document.createElement('div');
                    deliveryInfoBox.setAttribute('class', 'deliveryInfoBox');
                    let title = document.createElement('div');
                    title.innerHTML = item['title'];
                    title.setAttribute('class', 'title');
                    deliveryInfoBox.append(title);
                    let name = document.createElement('span');
                    name.innerHTML = "주문자들 : "+item['name']+"<br>";
                    deliveryInfoBox.append(name);
                    let address = document.createElement('span');
                    address.innerHTML = "주소 : "+item['address']+"<br>";
                    deliveryInfoBox.append(address);
                    let phone = document.createElement('span');
                    phone.innerHTML = "전화번호 : "+item['phone']+"<br>";
                    deliveryInfoBox.append(phone);
                    let order_date = document.createElement('span');
                    order_date.innerHTML = "주문일 : "+item['order_date']+"<br>";
                    deliveryInfoBox.append(order_date);

                    let orderBox = document.createElement('div');
                    orderBox.setAttribute('class', 'orderBox');
                    orderBox.append(imgBox);
                    orderBox.append(deliveryInfoBox);

                    completedDelivery.append(orderBox);
                });

            },
            error : function(data) {
                console.log(data);
            }
        });
    }
</script>
</body>
</html>


