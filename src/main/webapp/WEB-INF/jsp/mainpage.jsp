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
            <h1>Welcome!</h1>
            <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
            <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
        </div>

        <!-- Example row of columns -->
        <div class="row">
            <div class="col-lg-4">
                <h2>column1</h2>
                <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>column2</h2>
                <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>column3</h2>
                <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>

        <jsp:include page="common/footer.jsp"/>
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
</body>
</html>
