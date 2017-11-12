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
        <div class="chart-body">
            <div class="chart">
                <canvas id="typeCountChart" width="400" height="400"></canvas>
                <p>自行车类型数量图</p>
            </div>
            <div class="chart" style="margin-left: 200px;">
                <canvas id="borrowCountChart" width="400" height="400"></canvas>
                <p>自行车租借次数图</p>
            </div>
        </div>
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
