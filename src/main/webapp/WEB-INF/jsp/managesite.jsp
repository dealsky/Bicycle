<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/11/8
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>administer</title>
    <jsp:include page="common/head.jsp"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
    <link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/administer.css"/>

    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/manageSite.js"></script>
</head>
<body>
    <jsp:include page="common/administerNav.jsp"/>

    <script>
        $(document).ready(function () {
            $(".nav-sidebar li").each(function () {
                $(this).removeClass("active");
            });
            $(".manage-site").parent().addClass("active");
        });
    </script>

    <div class="col-md-10 col-md-offset-2 main">
        <h1 class="page-header">站点管理</h1>
        <div id="toolbar">
            <div class="btn-group">
                <button class="btn btn-default" data-toggle="modal" data-target="#modalAddTable">
                    <i class="fa fa-plus fa-lg"></i> 新增
                </button>
                <button class="btn btn-default" id="delete-table">
                    <i class="fa fa-trash fa-lg"></i> 删除
                </button>
            </div>
        </div>
        <table id="SiteTable" data-toolbar="#toolbar"></table>
    </div>
    <div class="modal fade" id="modalAddTable" role="dialog" aria-labelledby="modalLabelAddTable" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="modalLabelAddTable">添加数据</h4>
                </div>
                <div class="modal-body">
                    <div class="row spacing form-group has-feedback" id="magId">
                        <div class="col-md-3 col-md-offset-2">
                            <label for="mag-id" class="control-label">管理员ID</label>
                        </div>
                        <div class="col-md-5">
                            <input id="mag-id" type="text" class="form-control"/>
                            <div class="feed-back">
                            </div>
                        </div>
                    </div>
                    <div class="row spacing form-group has-feedback" id="siteArea">
                        <div class="col-md-3 col-md-offset-2">
                            <label for="site-area" class="control-label">所属区域</label>
                        </div>
                        <div class="col-md-5">
                            <input id="site-area" type="text" class="form-control"/>
                            <div class="feed-back">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="addTableConfirm" disabled="disabled">确认</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
