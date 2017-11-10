$(document).ready(function () {

    $("#modalAddTable").modal({
        backdrop: false,
        show: false
    });

    $('#BicycleTable').bootstrapTable({
        columns: [
            {
                fileid: 'bicycle.bicid',
                checkbox: true
            },
            {
                field: 'bicycle.bicnumber',
                title: '编号',
                sortable: true
            },
            {
                field: 'bicycle.bictype',
                title: '类型',
                sortable: true,
                editable: {
                    type: "text",
                    title: "类型",
                    width: "10%",
                    align: "right",
                    validate: function (v) {
                        if(!v) {
                            return "不能为空";
                        }
                    }
                }
            },
            {
                field: 'bicycle.bicrentprice',
                title: '价格/(小时)',
                sortable: true,
                editable: {
                    type: "text",
                    title: "价格/(小时)",
                    width: "10%",
                    align: "center",
                    validate: function(v) {
                        if(!v)
                            return "不能为空";
                        if(isNaN(v))
                            return "输入必须为数字";
                    }
                }
            },
            {
                field: 'site.sitenumber',
                title: '站点编号',
                sortable: true,
                formatter: function (value) {
                    if(value === null) {
                        return "无";
                    } else {
                        return value;
                    }
                },
                searchable: false
            },
            {
                field: 'user.username',
                title: '租借者',
                sortable: true,
                formatter: function (value) {
                    if(value === null) {
                        return "无";
                    } else {
                        return value;
                    }
                },
                searchable: false
            },
            {
                field: 'bicycle.bicborrowed',
                title: '借还状态',
                sortable: true,
                formatter: function (value) {
                    if(value === 1) {
                        return "被借";
                    } else {
                        return "没被借";
                    }
                }
            },
            {
                field: 'bicycle.bicborrowedcount',
                title: '被借次数',
                sortable: true
            },
            {
                field: 'bicycle.bicbuytime',
                title: '购买时间',
                sortable: true,
                formatter: function (value) {
                    var date = new Date(value);
                    return date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate();
                }
            }
        ],
        url: "/Bicycle/Administer/TableBicycle.do",
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
            if(field === "bicycle.bicrentprice") {
                row.bicycle.bicrentprice = row[field];
            } else if(field === "bicycle.bictype") {
                row.bicycle.bictype = row[field];
            }
            $.ajax({
                type: "POST",
                url: "/Bicycle/Administer/EditBicycle.do",
                dataType: "json",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(row.bicycle),
                success: function (data) {
                    var opt = {
                        url: "/Bicycle/Administer/TableBicycle.do",
                        silent: true,
                        query:{
                            type:1,
                            level:2
                        }
                    };
                    $('#BicycleTable').bootstrapTable('refresh', opt);
                    alert("修改成功！");
                },
                error: function (xhr) {
                    console.log(xhr.responseText);
                }
            });
        }
    });

    $("#addTableConfirm").bind("click", addTable);
    $("#delete-table").bind("click", deleteTable);

    $(".close").bind("click", clearForm);
    $("#bic-type").bind("change", typeJudge);
    $("#bic-price").bind("change", priceJudge);
    $("#bic-site").bind("change", siteJudge);
    $("#bic-time").bind("change", timeJudge);

});

var flag = [];

function typeJudge() {
    var text = $("#bic-type").val();
    if(text.length>0 && text.length <10) {
        $("#bicType").addClass("has-success");
        $("#bicType").removeClass("has-error");
        $("#bicType .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[0] = true;
    } else {
        $("#bicType").addClass("has-error");
        $("#bicType").removeClass("has-success");
        $("#bicType .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">类型名太长或太短</span>");
        flag[0] = false;
    }
    ableButton();
}

function priceJudge() {
    var text = $("#bic-price").val();
    if(!isNaN(text)) {
        $("#bicPrice").addClass("has-success");
        $("#bicPrice").removeClass("has-error");
        $("#bicPrice .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[1] = true;
    } else {
        $("#bicPrice").addClass("has-error");
        $("#bicPrice").removeClass("has-success");
        $("#bicPrice .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">输入必须为数字</span>");
        flag[1] = false;
    }
    ableButton();
}

function siteJudge() {
    var text = $("#bic-site").val();
    if(!isNaN(text)) {
        $.ajax({
            url: "/Bicycle/Administer/JudgeSite.do",
            type: "POST",
            dataType: "json",
            data: {siteNumber: text},
            success: function (data) {
                if (data.errorLog === "right") {
                    $("#bicSite").addClass("has-success");
                    $("#bicSite").removeClass("has-error");
                    $("#bicSite .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
                    flag[2] = true;
                } else {
                    $("#bicSite").addClass("has-error");
                    $("#bicSite").removeClass("has-success");
                    $("#bicSite .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
                        "                                <span class=\"error-message\">该站点不存在</span>");
                    flag[2] = false;
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
    } else {
        $("#bicSite").addClass("has-error");
        $("#bicSite").removeClass("has-success");
        $("#bicSite .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">该站点不存在</span>");
        flag[2] = false;
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

function timeJudge() {
    var text = $("#bic-time").val();
    if(text !== "") {
        $("#bicTime").addClass("has-success");
        $("#bicTime").removeClass("has-error");
        $("#bicTime .feed-back").html("<span class=\"glyphicon glyphicon-ok form-control-feedback glyp-right\"></span>");
        flag[3] = true;
    } else {
        $("#bicTime").addClass("has-error");
        $("#bicTime").removeClass("has-success");
        $("#bicTime .feed-back").html("<span class=\"glyphicon glyphicon-remove form-control-feedback glyp-right\"></span>\n" +
            "                                <span class=\"error-message\">日期不能为空</span>");
        flag[3] = false;
    }
    ableButton();
}

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

function addTable() {
    var bicType = $("#bic-type").val();
    var bicPrice = $("#bic-price").val();
    var siteNumber = $("#bic-site").val();
    var bicBuyTime = $("#bic-time").val();
    $.ajax({
        url: "/Bicycle/Administer/AddTable.do",
        type: "POST",
        dataType: "json",
        data: {
            bicType: bicType,
            bicPrice: bicPrice,
            siteNumber: siteNumber,
            bicBuyTime: new Date(bicBuyTime)
        },
        success: function (data) {
            if(data.errorLog === "right") {
                var opt = {
                    url: "/Bicycle/Administer/TableBicycle.do",
                    silent: true,
                    query:{
                        type:1,
                        level:2
                    }
                };
                $("#modalAddTable").modal('hide');
                alert("添加成功！");
                clearForm();
                $('#BicycleTable').bootstrapTable('refresh', opt);
            }
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function deleteTable() {
    var arr = ($('#BicycleTable').bootstrapTable('getSelections'));
    var array = new Array();
    if(arr.length !== 0) {
        for(var i = 0; i<arr.length; i++) {
            array.push(arr[i].bicycle);
        }
        $.ajax({
            url: "/Bicycle/Administer/DeleteTable.do",
            type: "POST",
            contentType:"application/json",
            dataType: "json",
            data: JSON.stringify(array),
            success: function (data) {
                var opt = {
                    url: "/Bicycle/Administer/TableBicycle.do",
                    silent: true,
                    query:{
                        type:1,
                        level:2
                    }
                };
                $('#BicycleTable').bootstrapTable('refresh', opt);
                alert("删除成功！");
            },
            error: function (xhr) {
                console.log(xhr.responseText)
            }
        });
    }
}