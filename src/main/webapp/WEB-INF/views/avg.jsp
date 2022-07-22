<%@ page import="bossbabies.com.a.dto.avg.CategorySaleRateDto" %>
<%@ page import="bossbabies.com.a.dto.avg.SalesByPeriodDto" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<CategorySaleRateDto> saleRateList = (List<CategorySaleRateDto>) request.getAttribute("saleRateByCategory");
    List<SalesByPeriodDto> periodList = (List<SalesByPeriodDto>) request.getAttribute("allPeriodList");

    // list(back) -> json(front)
    String jsonData = "[";
    for (CategorySaleRateDto dto : saleRateList) {
        jsonData += "{ name:'" + dto.getCategory() + "', y:" + dto.getPercent() + "}, ";
    }
    jsonData = jsonData.substring(0, jsonData.lastIndexOf(","));
    jsonData += "]";
    request.setAttribute("jsonData", jsonData);

    /* ******************************초기 차트 생성 (전체 기간)******************************** */
    String startStr = periodList.get(0).getOrderDate().split("-")[0].substring(2, 4) + periodList.get(0).getOrderDate().split("-")[1] + periodList.get(0).getOrderDate().split("-")[2];
    String endStr = periodList.get(periodList.size() - 1).getOrderDate().split("-")[0].substring(2, 4) + periodList.get(periodList.size() - 1).getOrderDate().split("-")[1] + periodList.get(periodList.size() - 1).getOrderDate().split("-")[2];
    int start = Integer.parseInt(startStr);
    int end = Integer.parseInt(endStr);
    int date[] = new int[end - start + 1];

    for (int i = 0; i < date.length; i++) {
        date[i] = start;
        start++;
    }
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < periodList.size(); i++) {
        SalesByPeriodDto dto = periodList.get(i);
        set.add(dto.getCategory());
        System.out.println(dto.getCountBook());
    }

    Iterator<String> iter = set.iterator();    // Iterator 사용
    List<String> categories = new ArrayList<>();
    while(iter.hasNext()){
        categories.add(iter.next());
    }


    int category_arr[][] = new int[set.size()][date.length];

    // 배열 초기화
    for (int i = 0; i < category_arr.length; i++) {
        for (int j = 0; j < category_arr[i].length; j++) {
            category_arr[i][j] = 0;
        }
    }
    System.out.println("set size : " + set.size());
    System.out.println("categories"+categories.size());

    for(int i=0;i<categories.size();i++){
        for (int j = 0; j < date.length; j++) {
            for (int k = 0; k < periodList.size(); k++) {
                int orderDateInt = Integer.parseInt((periodList.get(k).getOrderDate()).split("-")[0].substring(2, 4) + (periodList.get(k).getOrderDate()).split("-")[1] + (periodList.get(k).getOrderDate()).split("-")[2]);
                if (orderDateInt == date[j] && periodList.get(k).getCategory().equals(categories.get(i))) {
                    category_arr[i][j] = periodList.get(k).getCountBook();
                }
            }
        }
    }
    for (int i=0;i<category_arr.length;i++){
        for (int j=0;j<category_arr[i].length;j++){
            System.out.println(category_arr[i][j] + " ");
        }
        System.out.println();
    }

    // list(back) -> json(front) (date)
    String dateJson = "[";
    for (int i = 0; i < date.length; i++) {
        dateJson += date[i] + ", ";
    }
    dateJson = dateJson.substring(0, dateJson.lastIndexOf(","));
    dateJson += "]";

    // list(back) -> json(front) (data)
    String dataJson = "[";
    for (int i = 0; i < category_arr.length; i++) {
        dataJson += "{ name:'" + categories.get(i) + "', data:[";
        for (int j = 0; j < category_arr[i].length; j++) {
            dataJson += category_arr[i][j] + ", ";
        }
        dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));
        dataJson += "]},";
    }
    dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));
    dataJson += "]";

    System.out.println(dataJson);
    System.out.println(dateJson);


%>

<html>
<head>
    <link rel="icon" type="image/x-icon" href="/resources/images/logo.png">
    <link rel="stylesheet" href="/resources/css/font.css">

    <title>MZ BOOK: 통계</title>

    <style>
        .highcharts-figure,
        .highcharts-data-table table {
            min-width: 320px;
            max-width: 800px;
            margin: 1em auto;
        }

        .highcharts-data-table table {
            font-family: Verdana, sans-serif;
            border-collapse: collapse;
            border: 1px solid #ebebeb;
            margin: 10px auto;
            text-align: center;
            width: 100%;
            max-width: 500px;
        }

        .highcharts-data-table caption {
            padding: 1em 0;
            font-size: 1.2em;
            color: #555;
        }

        .highcharts-data-table th {
            font-weight: 600;
            padding: 0.5em;
        }

        .highcharts-data-table td,
        .highcharts-data-table th,
        .highcharts-data-table caption {
            padding: 0.5em;
        }

        .highcharts-data-table thead tr,
        .highcharts-data-table tr:nth-child(even) {
            background: #f8f8f8;
        }

        .highcharts-data-table tr:hover {
            background: #f1f7ff;
        }

        input[type="number"] {
            min-width: 50px;
        }

        /**/
        .highcharts-figure,
        .highcharts-data-table table {
            min-width: 360px;
            max-width: 800px;
            margin: 1em auto;
        }

        .highcharts-data-table table {
            font-family: Verdana, sans-serif;
            border-collapse: collapse;
            border: 1px solid #ebebeb;
            margin: 10px auto;
            text-align: center;
            width: 100%;
            max-width: 500px;
        }

        .highcharts-data-table caption {
            padding: 1em 0;
            font-size: 1.2em;
            color: #555;
        }

        .highcharts-data-table th {
            font-weight: 600;
            padding: 0.5em;
        }

        .highcharts-data-table td,
        .highcharts-data-table th,
        .highcharts-data-table caption {
            padding: 0.5em;
        }

        .highcharts-data-table thead tr,
        .highcharts-data-table tr:nth-child(even) {
            background: #f8f8f8;
        }

        .highcharts-data-table tr:hover {
            background: #f1f7ff;
        }
    </style>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">
</head>
<body>
<%@ include file="layout/header.jsp" %>
<br><br>
<div id="pie-chart"></div>
<br><br>
<hr>
<br><br>
<div id="choiceDate" align="center">
    <input type="date" id="beforeDate"> ~ <input type="date" id="afterDate">
    <button id="btn" class="btn btn-outline-success">선택</button>
</div>
<br><br>
<div id="line-chart"></div>

<script>
    Highcharts.chart('pie-chart', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: '카테고리 별 도서 순위'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        accessibility: {
            point: {
                valueSuffix: '%'
            }
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: <%= request.getAttribute("jsonData") %>
        }]
    });

    let line_chart = Highcharts.chart('line-chart', {

        title: {
            text: '기간 별 매출현황'
        },

        subtitle: {
            text: '언제 무슨 카테고리가 많이 팔렸는가?'
        },

        yAxis: {
            title: {
                text: 'Number of books'
            }
        },

        xAxis: {
            categories: <%=dateJson%>
        },

        series: <%=dataJson%>,

        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },


        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });


</script>

<script>

    $(document).ready(function () {
        $("#btn").click(function () {
            let beforeDate = document.getElementById("beforeDate").value;
            let beforeStr = beforeDate.split('-')[0].substring(2, 4) + beforeDate.split('-')[1] + beforeDate.split('-')[2];
            let afterDate = document.getElementById("afterDate").value;
            let afterStr = afterDate.split('-')[0].substring(2, 4) + afterDate.split('-')[1] + afterDate.split('-')[2];
            $.ajax({
                url: "line-chart.do?beforeStr=" + beforeStr + "&afterStr=" + afterStr,
                dataType: "json",
                success: function (data) {
                    resultPeriodList(data); // 함수 호출
                },
                error: function () {
                    alert("로딩실패!");
                }
            });
        });
    });

    function resultPeriodList(data) {
        let beforeDate = document.getElementById("beforeDate").value;
        let beforeStr = beforeDate.split('-')[0].substring(2, 4) + beforeDate.split('-')[1] + beforeDate.split('-')[2];
        let afterDate = document.getElementById("afterDate").value;
        let afterStr = afterDate.split('-')[0].substring(2, 4) + afterDate.split('-')[1] + afterDate.split('-')[2];
        let start = beforeStr * 1;
        let end = afterStr * 1;
        let date = [];
        let index = 0;

        // start - end 까지 년도 저장
        for (let i = start; i <= end; i++) {
            date[index] = i;
            index++;
        }

        // book category 저장
        let set = new Set();
        for (let i = 0; i < data.length; i++) {
            set.add(data[i].category);
        }
        let categories = Array.from(set);

        if (set.size == 0) {
            alert("선택된 날짜에 판매한 책이 없습니다. 다른 날짜를 선택해주세요!");
        }

        let category_arr = new Array(categories.length);
        for (let i = 0; i < category_arr.length; i++) {
            category_arr[i] = new Array(date.length);
        }

        for (let i = 0; i < category_arr.length; i++) {
            for (let j = 0; j < category_arr[i].length; j++) {
                category_arr[i][j] = 0;
            }
        }

        for (let i = 0; i < categories.length; i++) {
            for (let j = 0; j < date.length; j++) {
                for (let k = 0; k < data.length; k++) {
                    let orderDateInt = ((data[k].orderDate).split("-")[0].substring(2, 4) + (data[k].orderDate).split("-")[1] + (data[k].orderDate).split("-")[2]) * 1;
                    if (orderDateInt == date[j] && data[k].category == categories[i]) {
                        category_arr[i][j] = data[k].countBook;
                    }
                }
            }
        }

        /************************************************************/

        // String to Json -> dateJson
        let dateJson = "["
        for (let i = 0; i < date.length; i++) {
            dateJson += date[i] + ", "
        }
        dateJson = dateJson.substring(0, dateJson.lastIndexOf(","));
        dateJson += "]";
        console.log(dateJson);

        // String to Json -> dataJson
        let dataJson = "[";
        for (let i = 0; i < category_arr.length; i++) {
            dataJson += "{ name:'" + categories[i] + "', data:["
            for (let j = 0; j < category_arr[i].length; j++) {
                dataJson += category_arr[i][j] + ", "
            }
            dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));
            dataJson += "]},";
        }
        dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));
        dataJson += "]";
        console.log(dataJson);

        line_chart = new Highcharts.chart('line-chart', {

            title: {
                text: '기간 별 매출현황'
            },

            subtitle: {
                text: '언제 무슨 카테고리가 많이 팔렸는가?'
            },

            yAxis: {
                title: {
                    text: 'Number of books'
                }
            },

            xAxis: {
                categories: date
            },

            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },

            responsive: {
                rules: [{
                    condition: {
                        maxWidth: 500
                    },
                    chartOptions: {
                        legend: {
                            layout: 'horizontal',
                            align: 'center',
                            verticalAlign: 'bottom'
                        }
                    }
                }]
            }
        });

        for (let i = 0; i < category_arr.length; i++) {
            line_chart.addSeries({
                name: categories[i],
                data: category_arr[i]
            });
        }
    }


</script>
<br><br>
<%@ include file="layout/footer.jsp" %>
<br><br>
</body>
</html>
