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

        <div class="borrow-bicycle">
            <div class="block">

            </div>

            <div style="margin-bottom: 65px;">
                <div>
                    <button type="button" class="btn btn-primary" style="float: right" id="bicycleSearch">查询</button>
                </div>
                <div class="col-md-3" style="float: right;">
                    <input type="text" class="form-control bicycle-search-input" placeholder="自行车编号"/>
                </div>
            </div>

            <div class="bicycle-table">
                <table class="table table-hover table-striped table-bordered">
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
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="borrowModal" tabindex="-1" role="dialog" aria-labelledby="borrowModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="borrowModalLabel"><i class="fa fa-bicycle"></i>　自行车租借</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <select class="form-control">
                            <option disabled="disabled" selected="selected">选择租借卡</option>
                            <option><span>卡号 123456</span><span style="margin-right: 30px;">余额12</span></option>
                            <option><span>卡号 123456</span><span style="float: right">余额</span></option>
                            <option><span>卡号 123456</span><span style="float: right">余额</span></option>
                            <option><span>卡号 123456</span><span style="float: right">余额</span></option>
                            <option><span>卡号 123456</span><span style="float: right">余额</span></option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">提交更改</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</body>
</html>
