<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/11/4
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bicycle</title>
    <jsp:include page="common/head.jsp"/>
    <script src="${pageContext.request.contextPath}/static/js/situation.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/general.css"/>
</head>
<body>
    <jsp:include page="common/nav.jsp"/>
    <div class="container">
        <%--<div class="chart-body">
            <div class="chart">
                <canvas id="typeCountChart" width="400" height="400"></canvas>
                <p>自行车类型数量图</p>
            </div>
            <div class="chart" style="margin-left: 200px;">
                <canvas id="borrowCountChart" width="400" height="400"></canvas>
                <p>自行车租借次数图</p>
            </div>
        </div>--%>

        <div class="bicycle-type-count">
            <h2 class="page-header">自行车</h2>
            <div class="p-and-chart col-md-11 col-md-offset-1">
                <div class="col-md-7 many-p">
                    <p>现在一共拥有自行车{{bicNum}}辆</p>
                    <p>数量最多的自行车型号为 {{maxType.type}}， 一共有{{maxType.count}}辆</p>
                    <p>数量最少的自行车型号为 {{minType.type}}， 只有{{minType.count}}辆</p>
                </div>
                <div class="col-md-4">
                    <div class="chart-body">
                        <canvas id="typeCountChart" width="400" height="400"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <div class="bicycle-borrow-count">
            <h2 class="page-header">租借情况</h2>
            <div class="p-and-chart col-md-11 col-md-offset-1">
                <div class="col-md-4">
                    <div class="chart-body">
                        <canvas id="borrowCountChart" width="400" height="400"></canvas>
                    </div>
                </div>
                <div class="col-md-4 col-md-offset-3 many-p">
                    <p>一共完成了自行车租借{{borrowSum}}次</p>
                    <p>租借数量最多的自行车型号为{{maxType.type}}型</p>
                    <p>租借数量最多的自行车型号为{{minType.type}}型</p>
                </div>
            </div>
        </div>

            <div class="bicycle-site-count">
                <h2 class="page-header">站点</h2>
                <div class="p-and-chart col-md-11 col-md-offset-1">
                    <div class="col-md-7 many-p">
                        <p>现在一共有{{siteNum}}个公共自行车站点</p>
                        <p>目前停车数量最多的站点编号是{{maxNumber}}</p>
                        <p>目前停车数量最少的站点编号是{{minNumber}}</p>
                    </div>
                    <div class="col-md-4">
                        <div class="chart-body">
                            <canvas id="countSiteChart" width="400" height="400"></canvas>
                        </div>
                    </div>
                </div>
            </div>

    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
