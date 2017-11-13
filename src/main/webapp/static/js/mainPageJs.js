$(document).ready(function () {

    var weatherData;

    $.ajax({
        url: "/Bicycle/User/GetWeather.action",
        type: "POST",
        datatype: "json",
        async: false,
        success: function (data) {
            var obj = eval('(' + data.weather + ')');
            var weather = obj.showapi_res_body;
            var cityInfo = weather.cityInfo;
            var today = weather.f1;
            var now = weather.now;
            weatherData = {
                temperature: now.temperature,
                weather: now.weather,
                day_air_temperature: today.day_air_temperature,
                night_air_temperature: today.night_air_temperature,
                aqi: now.aqi,
                sd: now.sd,
                wind_direction: now.wind_direction,
                wind_power: now.wind_power,
                city: cityInfo.c3,
                cityE: cityInfo.c2
            };
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });

    new Vue({
        el: '#weather-today',
        data: weatherData
    });

    $("#modalLogin").modal({
        backdrop: false,
        show: false
    });

    $("#modalRegister").modal({
        backdrop: false,
        show: false
    });

    $("#loginButton").click(function () {
        var userAcc = $(".login-text [name='userAcc']").val();
        var userPAss = $(".login-text [name='userPass']").val();

        //  loading动画（待填坑）
        // var target = document.getElementById("error-message");
        // var spinner = new Spinner(opts).spin(target);

        $.ajax({
            url: "/Bicycle/User/login.action",
            type: "POST",
            dataType: "json",
            data: {
                userAcc: userAcc,
                userPass: userPAss
            },
            success: function (data) {
                if(data.meg === "passError"){
                    $("#error-message").html("<div class='alert alert-danger login-message'>密码错误</div>");
                } else if(data.meg === "null"){
                    $("#error-message").html("<div class='alert alert-danger login-message'>账号不存在</div>");
                } else if(data.meg === "ok"){
                    $("#error-message").html("<div class='alert alert-success login-message'>登录成功</div>");
                    window.location.href = "/Bicycle/User/Home";
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
    });

    var status = [];
    $(".register-body [name='userAcc']").bind("change", function () {
        var userAcc = $(this).val();
        if(userAcc.length<6 || userAcc.length>12) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">账号长度 6 ~ 12</span>";
            $("#groupAcc .error-if").html(icon + message);
            $("#groupAcc").addClass("has-error");
            status[0] = false;
        } else {
            $.ajax({
                url: "/Bicycle/User/register.userAcc",
                type: "POST",
                dataType: "json",
                data: {userAcc: userAcc},
                success: function(data) {
                    if(data.message === "right") {
                        $("#groupAcc").removeClass("has-error");
                        var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                        $("#groupAcc .error-if").html(icon);
                        $("#groupAcc").addClass("has-success");
                        status[0] = true;
                    } else {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var message = "<span class=\"register-error-message\">该账号已被注册</span>";
                        $("#groupAcc .error-if").html(icon + message);
                        $("#groupAcc").addClass("has-error");
                        status[0] = false;
                    }
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                    status[0] = false;
                }
            });
        }
    });

    $(".register-body [name='userPass']").bind("change", function () {
        var userPass = $(this).val();
        if(userPass.length<6 || userPass.length>12) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">密码长度 6 ~ 18</span>";
            $("#groupPass .error-if").html(icon + message);
            $("#groupPass").addClass("has-error");
            status[1] = false;
        } else {
            $("#groupPass").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupPass .error-if").html(icon);
            $("#groupPass").addClass("has-success");
            status[1] = true;
        }
    });

    $(".register-body [name='userEmail']").bind("change", function () {
        var userEmail = $(this).val();
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(reg.test(userEmail)) {
            $.ajax({
                url: "/Bicycle/User/register.userEmail",
                type: "POST",
                dataType: "json",
                data: {
                    userEmail: userEmail
                },
                success: function (data) {
                    if(data.message === "error") {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var message = "<span class=\"register-error-message\">该邮箱已被使用</span>";
                        $("#groupEmail .error-if").html(icon + message);
                        $("#groupEmail").addClass("has-error");
                        status[2] = false;
                    } else {
                        $("#groupEmail").removeClass("has-error");
                        var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                        $("#groupEmail .error-if").html(icon);
                        $("#groupEmail").addClass("has-success");
                        status[2] = true;
                    }
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                    status[2] = false;
                }
            });
        } else {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">邮箱格式错误</span>";
            $("#groupEmail .error-if").html(icon + message);
            $("#groupEmail").addClass("has-error");
            status[2] = false;
        }
    });

    $(".register-body [name='userName']").bind("change", function () {
        var userName = $(this).val();
        if(userName.length <2 || userName.length > 12) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">用户名长度 2~12</span>";
            $("#groupName .error-if").html(icon + message);
            $("#groupName").addClass("has-error");
            status[3] = false;
        } else {
            $("#groupName").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#groupName .error-if").html(icon);
            $("#groupName").addClass("has-success");
            status[3] = true;
        }
    });

    $("#registerButton").click(function () {
        var userAcc = $(".register-text [name='userAcc']").val();
        var userPass = $(".register-text [name='userPass']").val();
        var userEmail = $(".register-text [name='userEmail']").val();
        var userName = $(".register-text [name='userName']").val();

        if(userAcc!=="" && userPass!=="" && userEmail!=="" && userName!==""){
            var flag = true;
            for(var i = 0; i<status.length; i++) {
                if(status[i] === false) {
                    flag = false;
                    break;
                }
            }
            if(flag === true) {
                $.ajax({
                    url: "/Bicycle/User/register.action",
                    type: "POST",
                    dataType: "json",
                    data: {
                        userAcc: userAcc,
                        userPass: userPass,
                        userEmail: userEmail,
                        userName: userName
                    },
                    success: function (data) {
                        console.log(data.meg);
                        if(data.meg === "null"){
                            $("#error-message-register").html("<div class='alert alert-danger register-message'>改账号已被注册</div>");
                        }
                        else if(data.meg === "emailError"){
                            $("#error-message-register").html("<div class='alert alert-danger register-message'>该邮箱已被注册</div>");
                        } else if(data.meg === "right"){
                            $("#error-message-register").html("<div class='alert alert-success register-message'>注册成功</div>");
                            $.post("/Bicycle/User/register.in", {userAcc: userAcc}, function () {
                                window.location.href = "/Bicycle/User/Home";
                            });
                        }
                    },
                    error: function (xhr) {
                        console.log(xhr.responseText);
                    }
                });
            } else {
                $("#error-message-register").html("<div class='alert alert-danger register-message'>请处理错误项</div>");
            }
        }
        else{
            $("#error-message-register").html("<div class='alert alert-danger register-message'>请填写完注册项</div>");
        }
    });

    var passStatus = [];
    $("#modalPass [name='oldPass']").bind("change", function () {
        var oldPass = $(this).val();
        $.ajax({
            url: "/Bicycle/changePass.pan",
            type: "POST",
            dataType: "json",
            data: {userPass: oldPass},
            success: function (data) {
                if(data.message === "right") {
                    $("#oldPass").removeClass("has-error");
                    var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
                    $("#oldPass .error-if").html(icon);
                    $("#oldPass").addClass("has-success");
                    passStatus[0] = true;
                } else {
                    var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                    var message = "<span class=\"register-error-message\">密码错误</span>";
                    $("#oldPass .error-if").html(icon + message);
                    $("#oldPass").addClass("has-error");
                    passStatus[0] = false;
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
                passStatus[0] = false;
            }
        });
    });

    $("#modalPass [name='newPass']").bind("change", function () {
        var newPass = $(this).val();
        if(newPass.length<6 || newPass.length>12) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">密码长度 6~18</span>";
            $("#newPass .error-if").html(icon + message);
            $("#newPass").addClass("has-error");
            passStatus[1] = false;
        } else {
            $("#newPass").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#newPass .error-if").html(icon);
            $("#newPass").addClass("has-success");
            passStatus[1] = true;
        }
    });

    $("#modalPass [name='passAgain']").bind("change", function () {
        var passAgain = $(this).val();
        if(passAgain !== $("[name='newPass']").val()) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"register-error-message\">两次输入结果不同</span>";
            $("#passAgain .error-if").html(icon + message);
            $("#passAgain").addClass("has-error");
            passStatus[2] = false;
        } else {
            $("#passAgain").removeClass("has-error");
            var icon = "<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>";
            $("#passAgain .error-if").html(icon);
            $("#passAgain").addClass("has-success");
            passStatus[2] = true;
        }
    });

    $("#updatePass").click(function () {
        var flag = true;
        for(var i = 0; i<passStatus.length; i++) {
            if(passStatus[i] === false) {
                flag = false;
                break;
            }
        }
        var oldPass = $("#modalPass [name='oldPass']").val();
        var newPass = $("#modalPass [name='newPass']").val();
        var passAgain = $("#modalPass [name='passAgain']").val();
        if(oldPass.length!==0 && newPass.length!==0 && passAgain.length!==0) {
            if(flag === false) {
                $("#modalPass .error-message").html("<div class='alert alert-danger login-message'>Error</div>");
            } else {
                $.ajax({
                    url: "/Bicycle/changePass.do",
                    type: "POST",
                    dataType: "json",
                    data: {userPass: newPass},
                    success: function (data) {
                        if(data.message === "success") {
                            $("#modalPass .error-message").html("<div class='alert alert-success login-message'>Success</div>");
                            window.location.href = "/Bicycle/User/Home";
                        }
                    },
                    error: function (xhr) {
                        console.log(xhr.responseText);
                        status[2] = false;
                    }
                });
            }
        } else {
            $("#modalPass .error-message").html("<div class='alert alert-danger login-message'>Wrong</div>");
        }
    });

});

function emptiedLogin() {
    $(".login-text [name='userAcc']").val("");
    $(".login-text [name='userPass']").val("");
    $("#error-message").html("");
}

function emptieRegister() {
    $(".register-text [name='userAcc']").val("");
    $(".register-text [name='userPass']").val("");
    $(".register-text [name='userEmail']").val("");
    $(".register-text [name='userName']").val("");
    $("#error-message-register").html("");
    $(".error-if").each(function () {
        $(this).html("");
    });
    $(".register-body .user-acc").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");
    });
}

function emptiePass() {
    $("#modalPass [type='password']").each(function () {
        $(this).val("");
    });
    $(".error-if").each(function () {
        $(this).html("");
    });
    $(".login-body .user-acc").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");
    });
    $("#modalPass .error-message").html("");
}

var opts = {
    lines: 12, // The number of lines to draw
    length: 2, // The length of each line
    width: 3, // The line thickness
    radius: 9, // The radius of the inner circle
    corners: 0.3, // Corner roundness (0..1)
    rotate: 0, // The rotation offset
    color: '#000', // #rgb or #rrggbb
    speed: 1, // Rounds per second
    trail: 54, // Afterglow percentage
    shadow: false, // Whether to render a shadow
    hwaccel: false, // Whether to use hardware acceleration
    className: 'spinner', // The CSS class to assign to the spinner
    zIndex: 2e9, // The z-index (defaults to 2000000000)
    top: 'auto', // Top position relative to parent in px
    left: 'auto' // Left position relative to parent in px
};