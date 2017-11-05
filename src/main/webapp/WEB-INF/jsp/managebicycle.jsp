<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/11/5
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>administer</title>
    <jsp:include page="common/head.jsp"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>

    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/js/managerBicycle.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/administer.css"/>
</head>
<body>
    <jsp:include page="common/administerNav.jsp"/>

    <script>
        $(document).ready(function () {
            $(".nav-sidebar li").each(function () {
                $(this).removeClass("active");
            });
            $(".manage-bicycle").parent().addClass("active");
        });
    </script>

    <div class="col-md-10 col-md-offset-2 main">
        <h1 class="page-header">自行车管理</h1>
        <div id="toolbar">
            <div class="btn-group">
                <button class="btn btn-default">
                    <i class="fa fa-plus fa-lg"></i>
                </button>
                <button class="btn btn-default">
                    <i class="fa fa-trash fa-lg"></i>
                </button>
            </div>
        </div>
        <table id="ArbetTable"
               data-toolbar="#toolbar"
               ></table>
    </div>
</body>
</html>
