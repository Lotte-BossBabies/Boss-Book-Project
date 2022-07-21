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
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        /* 공통 부분 */
        .title{
            font-size: 24px;
        }
        .lineBox{
            border-bottom: 2px solid black;
            margin: 20px 0px;
        }
        .countBox{
            margin-left: 80px;
            font-size: 20px;
        }
        .deliveryCount{
            font-weight: bold;
            font-size: 22px;
        }
        .contentBox{
            width: 600px;
            margin: 10px auto;
            padding-left: 20px;
        }
        .orderBox{
            width: 700px;
            margin: 10px auto;
            padding-bottom: 5px;
            display: grid;
            grid-template-columns: 110px 490px 100px;
        }
        .imgBox{
            grid-column: 1/2;
        }
        .deliveryInfoBox{
            grid-column: 2/3;
        }
        .title{
            font-size: 18px;
            margin-bottom: 5px;
        }


        /* 배송 전 상품 */
        .preDeliveryWrapper{
            width: 800px;
            margin: 50px auto;
        }
        .buttonBox{
            grid-column: 3/4;
        }
        #deliveryBtn{
            width: 70px;
            height: 30px;
            margin-top: 50px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 14px;
            cursor: pointer;
        }
        #deliveryBtn:hover{
            border: 2px solid cornflowerblue;
            color: cornflowerblue;
        }

        /* 배송 후 상품 */
        .completedDeliveryWrapper{
            width: 800px;
            margin: 40px auto;
        }
        .dateBox{
            width: 450px;
            margin: 30px auto;
        }
        .dateBox > input{
            width: 160px;
            height: 30px;
        }
        .dateBox > button{
            width: 70px;
            height: 30px;
            margin-left: 20px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: white;
            font-size: 14px;
            cursor: pointer;
        }
        .dateBox > button:hover{
            border: 2px solid cornflowerblue;
            color: cornflowerblue;
        }
    </style>
</head>
<body>

<div>
    <div class="preDeliveryWrapper">
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
                    name.innerHTML = item['name']+"<br>";
                    deliveryInfoBox.append(name);
                    let address = document.createElement('span');
                    address.innerHTML = item['address']+"<br>";
                    deliveryInfoBox.append(address);
                    let phone = document.createElement('span');
                    phone.innerHTML = item['phone']+"<br>";
                    deliveryInfoBox.append(phone);
                    let order_date = document.createElement('span');
                    order_date.innerHTML = item['order_date']+"<br>";
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


