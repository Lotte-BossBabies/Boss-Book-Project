<%@ page import="bossbabies.com.a.dto.user.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    type = {0 : 로그인X, 1 : 멤버, 2 : 셀러}
    int type = 0;
    Object obj = session.getAttribute("login");
    if (obj != null) {
        if(obj.getClass().equals(MemberDto.class)) type = 1;
        else type = 2;
    }

%>

<div id="header">
    <div class="header_top">
        <div class="header_top_cont">
            <ul class="top_member_box">
                <%
                    if (type != 0) {
                %>
                <li>
                    <a href="logout.do">LOGOUT</a>
                    <span class="txt_bar"></span>
                </li>
                <%
                    if (type == 1) {
                %>
                <li>
                    <a href="mypage.do">MYPAGE</a>
                    <span class="txt_bar"></span>
                </li>
                <%
                } else {
                %>

                <li>
                    <a href="adminMain.do?sellerId=1&sellStatus=1">MYPAGE</a>
                    <span class="txt_bar"></span>
                </li>
                <%
                    }
                } else {
                %>
                <li>
                    <a href="login.do">LOGIN</a>
                    <span class="txt_bar"></span>
                </li>
                <li>
                    <a href="userSelect.do">JOIN</a>
                    <span class="txt_bar"></span>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>

    <div class="header_bottom header_search">
        <div class="header_search_cont">
            <div class="h1_logo">
                <a href="main.do">
                    <%--image 넣을 예정--%>
                    <img width="100px" src="resources/images/logo.png" title="로고 이미지">
                    <div class="logoname">MZ BOOK</div>
                </a>
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
                        <a href="bookstore.do?cateName=all">서점</a>
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
