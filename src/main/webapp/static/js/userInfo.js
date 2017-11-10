$(document).ready(function () {

    disableUserInfo(true);

    $("#changeUserInfo").click(function () {
        disableUserInfo(false);
    });

    var status = [];
    $(".user-info-form [name='userName']").bind("change", function () {
        var userName = $(this).val();
        if(userName.length<2 || userName.length>12) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"error-message\">用户名长度 2 ~ 12</span>";
            $("#groupName .error-if").html(icon + message);
            $("#groupName").addClass("has-error");
            status[0] = false;
        } else {
            $("#groupName .error-if").html("");
            $("#groupName").removeClass("has-error");
            status[0] = true;
        }
        updateUserInfo(status);
    });

    $(".user-info-form [name='userEmail']").bind("change", function () {
        var userEmail = $(this).val();
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(reg.test(userEmail)) {
            $.ajax({
                url: "/Bicycle/User/UpEmail.do",
                type: "POST",
                dataType: "json",
                data: {
                    userEmail: userEmail
                },
                success: function (data) {
                    if(data.message === "error") {
                        var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
                        var message = "<span class=\"error-message\">该邮箱已被使用</span>";
                        $("#groupEmail .error-if").html(icon + message);
                        $("#groupEmail").addClass("has-error");
                        status[1] = false;
                    } else {
                        $("#groupEmail .error-if").html("");
                        $("#groupEmail").removeClass("has-error");
                        status[1] = true;
                    }
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                    status[1] = false;
                }
            });
        } else {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"error-message\">邮箱格式错误</span>";
            $("#groupEmail .error-if").html(icon + message);
            $("#groupEmail").addClass("has-error");
            status[1] = false;
        }
        updateUserInfo(status);
    });

    $(".user-info-form [name='userTel']").bind("change", function () {
        var reg= /^((0\d{2,3}-\d{7,8})|(1[35847]\d{9}))$/;
        if(!reg.test($(this).val())) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"error-message\">请输入正确的手机号码</span>";
            $("#groupTel .error-if").html(icon + message);
            $("#groupTel").addClass("has-error");
            status[2] = false;
        } else {
            $("#groupTel .error-if").html("");
            $("#groupTel").removeClass("has-error");
            status[2] = true;
        }
        updateUserInfo(status);
    });

    $(".user-info-form [name='userIdCard']").bind("change", function () {
        var reg = /(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if(!reg.test($(this).val())) {
            var icon = "<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>";
            var message = "<span class=\"error-message\">身份证号格式错误</span>";
            $("#groupIdCard .error-if").html(icon + message);
            $("#groupIdCard").addClass("has-error");
            status[3] = false;
        } else {
            $("#groupIdCard .error-if").html("");
            $("#groupIdCard").removeClass("has-error");
            status[3] = true;
        }
        updateUserInfo(status);
    });

    $(".user-info-form [name='userSex']").bind("change", function () {
        updateUserInfo(status);
    });
});

$(function () {
    $("[data-toggle='tooltip']").tooltip();
});

function disableUserInfo(status) {
    $(".user-info-form input").each(function () {
        $(this).attr("disabled", status);
    });
}

function updateUserInfo(status) {
    var flag = true;
    for(var i = 0; i<status.length; i++) {
        if(status[i] === false) {
            flag = false;
            break;
        }
    }
    if(flag === true) {
        $("#saveChange").attr("disabled", false);
    } else {
        $("#saveChange").attr("disabled", true);
    }
}