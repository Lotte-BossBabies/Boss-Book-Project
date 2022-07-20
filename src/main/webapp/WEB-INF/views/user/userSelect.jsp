<%--
  Created by IntelliJ IDEA.
  User: kjchoi
  Date: 2022/07/18
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            width: 80%;
            height: 500px;
            text-align: center;
            border: 1px solid #000;
        }
        div.left{
            width:50%;
            float: left;
            box-sizing: border-box;
            background: #ff0;
        }
        div.right{
            width:50%;
            float: right;
            box-sizing: border-box;
            background: #0ff;
        }
        button{
            margin:auto;
        }

    </style>
</head>
<body>

<div>
    <div class="left">
        <button onclick="clickCommon()">일반 14세 이상</button>
    </div>
    <div class="right">
        <button onclick="clickSeller()">판매자</button>
    </div>
</div>

<script>
    function clickCommon() {
        location.href = "memberRegi.do";
    }
    function clickSeller() {
        location.href = "sellerRegi.do";
    }

</script>
</body>
</html>
