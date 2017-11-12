<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/10/23
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>bicycle</title>
    <link href="${pageContext.request.contextPath}/static/css/mainPage.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="common/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/zoomify/zoomify.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/zoomify/zoomify.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/mainPageJs.js"></script>
</head>
<body>

    <jsp:include page="common/nav.jsp"/>
    <div class="container">
        <div>
            <div id="foo"></div>
        </div>

        <!-- Jumbotron -->
        <div class="jumbotron">
            <h1>欢迎!</h1>
            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
            <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
            <div class="weather-today">
                <%--<img src="http://app1.showapi.com/weather/icon/day/01.png"/>--%>
            </div>
        </div>

        <!-- Example row of columns -->
        <div class="row">
            <div class="col-lg-4">
                <h2>最新公告</h2>
                <p>
                    （1）点击页面右上角注册账号，用注册好的账号登录系统。（2）借车前请先办理租借卡，办理完成后可以进行充值。
                    （3）在借车/还车界面，可以根据站点查找某一个站点的自行车，也可以直接通过编号来查询自行车。（4）在找到了
                    想要借走的自行车后，点击借车按钮可以借到该车。但是要注意的是，如果租借卡的余额较少时，是无法完成借车操作的，
                    所以，在借车前请务确保租借卡中有足够的余额。（5）还车同样是在借车/还车界面，在还车站点中输入归还自行车的站点，
                    然后点击还车按钮，即可完成还车操作。
                </p>
                <p><a class="btn btn-default" href="#" role="button">查看详细信息 &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>租/还车流程</h2>
                <img class="zoomify" src="${pageContext.request.contextPath}/static/image/howToUse.jpg" width="360px">
                <script type="text/javascript">
                    $('.zoomify').zoomify();
                </script>
            </div>
            <div class="col-lg-4">
                <h2>今日天气</h2>
                <%--<div class="weather-info">--%>
                    <%--所在城市<p></p>--%>

                <%--</div>--%>
                <div id="weather-today">
                    <div class="weather-info left col-md-5 col-md-offset-1">
                        <h1>{{temperature}}&#186;</h1>
                        <p>{{weather}} {{day_air_temperature}}&#186;/{{night_air_temperature}}&#186;C</p>
                        <p>空气质量指数: {{aqi}}</p>
                        <p>空气湿度: {{sd}}</p>
                        <p>风向: {{wind_direction}}</p>
                        <p>风力: {{wind_power}}</p>
                    </div>
                    <div class="weather-img right col-md-5">
                        <img src="http://app1.showapi.com/weather/icon/day/01.png"/>
                        <h2>{{city}}</h2>
                        <h3>{{cityE}}</h3>
                    </div>
                </div>


            </div>
        </div>

    </div>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="modalLogin" role="dialog" aria-labelledby="modalLabelLogin" aria-hidden="true">
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptiedLogin()">&times;</button>
                    <h4 class="modal-title" id="modalLabelLogin">用户登录</h4>
                </div>
                <form action="" method="post">
                    <div class="modal-body login-body">
                        <div class="row user-acc">
                            <div class="login-label">
                                <label class="control-label">账号</label>
                            </div>
                            <div class="login-text">
                                <input type="text" class="form-control" name="userAcc" placeholder="账号"/>
                            </div>
                        </div>
                        <div class="row user-acc">
                            <div class="login-label">
                                <label class="control-label">密码</label>
                            </div>
                            <div class="login-text">
                                <input type="password" class="form-control" name="userPass" placeholder="密码"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div id="error-message" class="error-message">
                        </div>
                        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="emptiedLogin()">关闭</button>
                        <button type="button" class="btn btn-primary" id="loginButton">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalRegister" role="dialog" aria-labelledby="modalLabelRegister" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptieRegister()">&times;</button>
                    <h4 class="modal-title" id="modalLabelRegister">用户注册</h4>
                </div>
                <form action="" method="post">
                    <div class="modal-body register-body">
                        <div class="row user-acc form-group has-feedback" id="groupAcc">
                            <div class="register-label">
                                <label class="control-label">账号</label>
                            </div>
                            <div class="register-text col-md-5">
                                <input type="text" class="form-control" name="userAcc" placeholder="账号"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                        <div class="row user-acc form-group has-feedback" id="groupPass">
                            <div class="register-label">
                                <label class="control-label">密码</label>
                            </div>
                            <div class="register-text col-md-5">
                                <input type="password" class="form-control" name="userPass" placeholder="密码"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                        <div class="row user-acc form-group has-feedback" id="groupEmail">
                            <div class="register-label">
                                <label class="control-label">邮箱</label>
                            </div>
                            <div class="register-text col-md-5">
                                <input type="email" class="form-control" name="userEmail" placeholder="example@abc.com"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                        <div class="row user-acc form-group has-feedback" id="groupName">
                            <div class="register-label">
                                <label class="control-label">昵称</label>
                            </div>
                            <div class="register-text col-md-5">
                                <input type="text" class="form-control" name="userName" placeholder="昵称"/>
                                <div class="error-if">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div id="error-message-register" class="error-message">
                        </div>
                        <button type="button" class="btn btn-primary" id="registerButton">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="common/changepass.jsp"/>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>
