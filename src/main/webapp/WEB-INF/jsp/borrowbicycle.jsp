<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/10/30
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>bicycle</title>
    <jsp:include page="common/head.jsp"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/general.css"/>
    <script src="${pageContext.request.contextPath}/static/js/borrowBicycle.js"></script>

</head>
<body onload="getArea()">
    <jsp:include page="common/nav.jsp"/>
    <div class="container">
        <div class="borrow-message">

        </div>

        <div class="borrow-bicycle">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">自行车列表</h3>
                </div>
                <div class="panel-body">
                    <div style="margin-bottom: 65px;">
                        <div>
                            <button type="button" class="btn btn-primary" style="float: right" id="bicycleSearch"><i class="fa fa-search"></i> 查询</button>
                        </div>
                        <div class="col-md-3" style="float: right;">
                            <input type="text" class="form-control bicycle-search-input" placeholder="自行车编号"/>
                        </div>
                    </div>

                    <div class="bicycle-table">
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>车型</th>
                                <th>价格/小时</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <div class="pagination page-bicycle">

                    </div>
                    <div class="form-group table-length">

                    </div>
                    <div id="displayBicycleError">

                    </div>
                </div>
            </div>

            <div class="panel panel-default" id="returnBicycle">
                <div class="panel-heading">
                    <h3 class="panel-title">当前借车</h3>
                </div>
                <div class="return-table">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>自行车编号</th>
                            <th>自行车类型</th>
                            <th>租借时长</th>
                            <th>预计扣款</th>
                            <th>还车站点</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div class="error-message">

                </div>
            </div>
        </div>



        <div class="panel panel-default check-site">
            <div class="panel-heading">
                <h3 class="panel-title">站点</h3>
            </div>
            <div class="panel-body">
                <div class="row search-form">
                    <div class="col-md-3">
                        <label>编号</label>
                    </div>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="siteNumber"/>
                    </div>
                    <button type="button" class="btn btn-success" id="searchSite"><i class="fa fa-search"></i> 查询</button>
                </div>

                <div class="searched-site">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>站点编号</th>
                            <th>所属区域</th>
                            <th>车数量</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <div id="searchedSiteError">

                </div>
            </div>

        </div>

        <div class="panel panel-default check-area">
            <div class="panel-heading">
                <h3 class="panel-title">区域</h3>
            </div>
            <div class="panel-body">
                <label>区域列表</label>
                <select class="form-control" id="checkSite">
                    <option disabled="disabled" selected="selected">选择一个区域</option>
                </select>

                <div class="site-table">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>站点编号</th>
                            <th>所属区域</th>
                            <th>车数量</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
                <ul class="pagination page-site">

                </ul>
            </div>
        </div>
    </div>
</body>
</html>
