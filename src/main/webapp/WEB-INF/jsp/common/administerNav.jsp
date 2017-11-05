<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/11/5
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/Bicycle/Administer">Administer</a>
        </div>
        <%
            if(session.getAttribute("manager") == null){%>
        <ul class="nav navbar-nav navbar-right">
            <li><a id="managerLoginHref" style="cursor: pointer;">登录</a></li>
        </ul>
        <form class="navbar-form navbar-right">
            <input type="text" class="form-control" id="managerAcc" placeholder="账号">
            <input type="password" class="form-control" id="managerPass" placeholder="密码">
        </form>
        <%}
        else{%>
        <ul class="nav navbar-nav navbar-right">
            <li><a>欢迎您</a></li>
            <li>
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    ${sessionScope.manager.magname} <b class="caret"></b>
                </a>
                <ul class="dropdown-menu" style="min-width: 120px;">
                    <li><a href="/Bicycle/ManagerLogout.do">安全退出</a></li>
                </ul>
            </li>
        </ul>
        <%}
        %>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/Bicycle/Administer">概述<span class="sr-only">(current)</span></a></li>
                <li><a href="#">自行车管理</a></li>
                <li><a href="#">站点管理</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="#">信息编辑</a></li>
            </ul>
        </div>
    </div>
</div>
