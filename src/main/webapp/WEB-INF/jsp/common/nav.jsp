<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/Bicycle/User/Home">Bicycle</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/Bicycle/User/Home">主页</a></li>
                <li><a href="/Bicycle/User/Borrow">借车/还车</a></li>
                <li><a href="/Bicycle/User/RentalCard">租借卡</a></li>
                <li><a href="/Bicycle/User/Situation">自行车租用情况</a></li>
            </ul>
        </div>
        <div class="navbar-right">
            <%
                if(session.getAttribute("user") == null){%>
            <ul class="nav navbar-nav">
                <li><a href="#" data-toggle="modal" data-target="#modalLogin">登录</a></li>
                <li><a href="#" data-toggle="modal" data-target="#modalRegister">注册</a></li>
            </ul>
            <%}
            else{%>
            <ul class="nav navbar-nav">
                <li><a>欢迎您</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        ${sessionScope.user.username} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu" style="min-width: 120px;">
                        <li><a href="/Bicycle/User/UserInfo">用户信息</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#modalPass">修改密码</a></li>
                        <li class="divider"></li>
                        <li><a href="/Bicycle/User/logout.do">安全退出</a></li>
                    </ul>
                </li>
            </ul>
            <%}
            %>
        </div>
    </div>
</nav>