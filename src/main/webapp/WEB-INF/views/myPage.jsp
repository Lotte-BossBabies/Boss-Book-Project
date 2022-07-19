<%@ page import="bossbabies.com.a.dto.mypage.MyPageDto" %>
<%@ page import="java.util.List" %>
<%@ page import="bossbabies.com.a.dto.mypage.OrderedBookDto" %>
<%@ page import="bossbabies.com.a.dto.mypage.LikedBookDto" %>
<%--
  Created by IntelliJ IDEA.
  User: BTC-N01
  Date: 2022-07-18
  Time: 오후 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MyPageDto member = (MyPageDto)request.getAttribute("member");
    List<OrderedBookDto> ol = (List<OrderedBookDto>)request.getAttribute("orderList");
    List<LikedBookDto> ll = (List<LikedBookDto>)request.getAttribute("likeList");
    System.out.println("MemberName: "+ member.getName());
    System.out.println("Memberid: "+member.getMemberId());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>마이페이지</h1>
<table border="1" style="text-align: center">
    <tr>
        <th colspan="5">멤버이름</th>
    </tr>
    <tr>
        <td colspan="5"><%=member.getName()%></td>
    </tr>
    <tr>
        <td colspan="5">구매한 상품</td>
    </tr>
    <%
        for(int i = 0; i < ol.size(); i++){
            OrderedBookDto orderBook = ol.get(i);
            %>
            <tr>
                <td><img src="<%=orderBook.getImageUrl()%>" alt="책책책"></td>
                <td><a href="bookDetail.do?bookId=<%=orderBook.getBookId()%>"><%=orderBook.getTitle()%></a></td><td><%=orderBook.getPrice()%></td>
                <td><%=orderBook.getOrder_date()%></td>
                <td><button onclick="location.href='cancelOrder.do?orderId=<%=orderBook.getOrderId()%>&memberId=<%=member.getMemberId()%>'">취소</button></td>
            </tr>
            <%
        }
    %>
    <tr>
        <td colspan="5">좋아요한 상품</td>
    </tr>
    <%
        for(int i = 0; i < ll.size(); i++){
            LikedBookDto likeBook = ll.get(i);
    %>
    <tr>
        <td><img src="<%=likeBook.getImageUrl()%>" alt="책책책"></td>
        <td><a href="bookDetail.do?bookId=<%=likeBook.getBookId()%>"><%=likeBook.getTitle()%></a></td>
        <td><%=likeBook.getPrice()%></td>
        <td colspan="2"><button onclick="location.href='order.do?likeId=<%=likeBook.getLikeId()%>'">취소</button></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td colspan="5">내가 작성한 리뷰</td>
    </tr>
</table>
</body>
</html>
