<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/11/5
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>administer</title>
    <jsp:include page="common/head.jsp"/>
    <script src="${pageContext.request.contextPath}/static/js/administer.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/situation.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/administer.css"/>
</head>
<body>
    <jsp:include page="common/administerNav.jsp"/>

    <%
        if (session.getAttribute("manager") != null) {%>
            <div class="col-md-10 col-md-offset-2 main">
                <h1 class="page-header">概况</h1>
                <div class="col-md-4 chart">
                    <canvas id="typeCountChart" width="400" height="400"></canvas>
                    <p>自行车数量</p>
                </div>
                <div class="col-md-4 chart">
                    <canvas id="borrowCountChart" width="400" height="400"></canvas>
                    <p>自行车租借次数</p>
                </div>
                <div class="col-md-4 chart">
                    <canvas id="countSiteChart" width="400" height="400"></canvas>
                    <p>站点停车数</p>
                </div>
            </div>
        <%}
    %>

</body>
</html>
