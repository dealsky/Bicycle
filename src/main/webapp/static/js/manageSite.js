$(document).ready(function () {

    $("#mag-id").bind("change", judgeMagId);
    $("#site-area").bind("change", judgeArea);
    $(".close").bind("click", clearForm);
    $("#addTableConfirm").bind("click", addTable);

    $('#SiteTable').bootstrapTable({
        columns:[
            {
                fileid: 'site.siteid',
                checkbox: true
            },
            {
                field: 'site.sitenumber',
                title: '编号',
                sortable: true
            },
            {
                field: 'site.magid',
                title: '管理员',
                sortable: true,
                formatter: function (value) {
                    $.ajax({
                        url: "/Bicycle/GetManager.do",
                        type: "POST",
                        dataType: "json",
                        async: false,
                        data: {magId: value},
                        success: function (data) {
                            if(data.manager) {
                                value = data.manager.magname;
                            } else {
                                value = "无";
                            }
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    });
                    return value;
                },
                editable: {
                    type: "text",
                    title: "管理员ID",
                    width: "10%",
                    align: "center",
                    validate: function(v) {
                        if(!v) {
                            return "不能为空";
                        }
                        else if(isNaN(v)) {
                            return "输入必须为数字";
                        }
                        else {
                            var flag = "";
                            $.ajax({
                                url: "/Bicycle/GetManager.do",
                                type: "POST",
                                dataType: "json",
                                async: false,
                                data: {magId: v},
                                success: function (data) {
                                    if(data.errorLog === "error") {
                                        flag = "该管理员不存在";
                                    }
                                },
                                error: function (xhr) {
                                    console.log(xhr.responseText);
                                }
                            });
                            if(flag !== "") {
                                return flag;
                            }
                        }
                    }
                }
            },
            {
                field: 'site.sitearea',
                title: '所属区域',
                sortable: true
            },
            {
                field: 'site.siteamount',
                title: '站点停车数量',
                sortable: true
            }
        ],
        url: "/Bicycle/TableSite.do",
        method: "POST",
        pagination: true,
        sidePagination: 'client',
        pageList: [5, 10, 20, 50],
        search: true,
        showRefresh: true,
        showToggle: true,
        //showColumns: true,
        clickToSelect: true,
        paginationLoop: false,
        paginationPreText: "前一页",
        paginationNextText: "后一页",
        height: 450,
        onEditableSave: function (field, row, oldValue, $el) {
            if(field === "site.magid") {
                row.site.magid = row[field];
            }
            $.ajax({
                type: "POST",
                url: "/Bicycle/EditSite.do",
                dataType: "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(row.site),
                success: function (data) {
                    var opt = {
                        url: "/Bicycle/TableSite.do",
                        silent: true,
                        query:{
                            type:1,
                            level:2
                        }
                    };
                    $('#SiteTable').bootstrapTable('refresh', opt);
                    alert("修改成功！");
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                }
            });
        }
    });

});

var flag = [];
function ableButton() {
    var f = true;
    for(var i = 0; i<flag.length; i++) {
        if(flag[i] === false) {
            f = false;
            break;
        }
    }
    if(f) {
        $("#addTableConfirm").attr("disabled", false);
    } else {
        $("#addTableConfirm").attr("disabled", true);
    }
}

function judgeMagId() {
    var text = $("#mag-id").val();
    //console.log(text);
    if(!isNaN(text)) {
        $.ajax({
            url: "/Bicycle/GetManager.do",
            type: "POST",
            dataType: "json",
            data: {magId: text},
            success: function (data) {
                if(data.errorLog === "right") {
                    $("#magId").addClass("has-success");
                    $("#magId").removeClass("has-error");
                    $("#magId .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
                    flag[0] = true;
                } else {
                    $("#magId").addClass("has-error");
                    $("#magId").removeClass("has-success");
                    $("#magId .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
                        "                                <span class=\"error-message\">该管理员不存在</span>");
                    flag[0] = false;
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
    } else {
        $("#magId").addClass("has-error");
        $("#magId").removeClass("has-success");
        $("#magId .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">该站点不存在</span>");
        flag[0] = false;
    }
    ableButton();
}

function judgeArea() {
    var text = $("#site-area").val();
    if(text.length > 0) {
        $("#siteArea").addClass("has-success");
        $("#siteArea").removeClass("has-error");
        $("#siteArea .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[1] = true;
    } else {
        $("#siteArea").addClass("has-error");
        $("#siteArea").removeClass("has-success");
        $("#siteArea .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">输入不能为空</span>");
        flag[1] = false;
    }
    ableButton();
}

function clearForm() {
    $("#modalAddTable .form-group").each(function () {
        $(this).removeClass("has-success");
        $(this).removeClass("has-error");

        $(this).find("input").val("");
        $(this).find(".feed-back").html("");
        $("#addTableConfirm").attr("disabled", true);
    });
}

function addTable() {
    var magId = $("#mag-id").val();
    var siteArea = $("#site-area").val();
    $.ajax({
        url: "/Bicycle/AddSite.do",
        type: "POST",
        dataType: "json",
        data: {
            magId: magId,
            siteArea: siteArea
        },
        success: function (data) {
            var opt = {
                url: "/Bicycle/TableSite.do",
                silent: true,
                query:{
                    type:1,
                    level:2
                }
            };
            $("#modalAddTable").modal('hide');
            alert("添加成功！");
            clearForm();
            $('#SiteTable').bootstrapTable('refresh', opt);
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}