$(document).ready(function () {

    $("#borrowModal").modal({
        backdrop: false,
        show: false
    });

    $(document).keydown(function(event){
        if(event.keyCode === 13) {
            $("#searchSite").trigger("click");
        }
    });

    $("#checkSite").bind("change", function () {
        var siteArea = $(this).find(":checked").text();
        $(".site-table tbody").html("");
        $(".page-site").html("");
        $.ajax({
            url: "/Bicycle/DisplaySite.do",
            type: "POST",
            dataType: "json",
            data: {siteArea: siteArea, pageNum: 1},
            success: function (data) {
                var sites = data.sites;
                var pageLen = data.pageLen;
                for(var i = 0; i<sites.length; i++) {
                    $(".site-table tbody").append("<tr>\n" +
                        "                            <td>" + sites[i].sitenumber + "</td>\n" +
                        "                            <td>" + sites[i].sitearea + "</td>\n" +
                        "                            <td>" + sites[i].siteamount + "</td>\n" +
                        "                        </tr>");
                }
                $(".page-site").append("<li><a onclick='pageTo(1, " + "\"" + siteArea + "\"" + ")'>&laquo;</a></li>");
                for(var i = 1; i<=pageLen; i++) {
                    if(i === 1) {
                        $(".page-site").append("<li class='active'><a onclick='pageTo(" + i + "," + "\"" + siteArea + "\"" + ")'>" + i + "</a></li>");
                    } else {
                        $(".page-site").append("<li><a onclick='pageTo(" + i + "," + "\"" + siteArea + "\"" + ")'>" + i + "</a></li>");
                    }
                }
                $(".page-site").append("<li><a onclick='pageTo(" + pageLen + "," + "\"" + siteArea + "\"" + ")'>&raquo;</a></li>");
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
    });

    $("#searchSite").click(function () {
        var siteNumber =  $("[name='siteNumber']").val();
        if(siteNumber === "") {
            return;
        }
        $("#searchedSiteError").html("");
        $(".searched-site tbody").html("");
        $("#displayBicycleError").html("");
        $(".bicycle-table tbody").html("");
        $(".page-bicycle").html("");
        $(".table-length").html("");
        $(".bicycle-search-input").val("");
        if(isNaN(siteNumber)) {
            $("#searchedSiteError").html("没有该站点!");
            return;
        }
        $.ajax({
            url: "/Bicycle/SearchSite.do",
            type: "POST",
            dataType: "json",
            data: {siteNumber: siteNumber},
            success: function (data) {
                if(data.message === "error") {
                    $("#searchedSiteError").html("没有该站点!");
                } else {
                    var site = data.site;
                    $(".searched-site tbody").append("<tr>\n" +
                        "                            <td>" + site.sitenumber + "</td>\n" +
                        "                            <td>" + site.sitearea + "</td>\n" +
                        "                            <td>" + site.siteamount + "</td>\n" +
                        "                        </tr>");
                    showBicycle(site.siteid, 1, 5);
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
        $("[name='siteNumber']").val("");
    });

    $("#bicycleSearch").click(function () {
        var bicycleNumber = $(".bicycle-search-input").val();
        if(bicycleNumber === "") {
            return;
        }
        $("#displayBicycleError").html("");
        $(".bicycle-table tbody").html("");
        $(".page-bicycle").html("");
        $(".table-length").html("");
        $("#searchedSiteError").html("");
        $(".searched-site tbody").html("");
        $(".bicycle-search-input").val("");
        if(isNaN(bicycleNumber)) {
            $("#displayBicycleError").html("没有该车！");
            return;
        }
        $.ajax({
            url: "/Bicycle/SearchBicycle.do",
            type: "POST",
            dataType: "json",
            data: {bicycleNumber: bicycleNumber},
            success: function (data) {
                if(data.message == "right") {
                    var bicycle = data.bicycle;
                    $(".bicycle-table tbody").append("<tr>\n" +
                        "                        <td>" + bicycle.bicnumber +"</td>\n" +
                        "                        <td>" + bicycle.bictype + "</td>\n" +
                        "                        <td>" + bicycle.bicrentprice + "</td>\n" +
                        "                        <td>\n" +
                        "                            <button type=\"button\" class=\"button button-rounded button-royal button-small borrow-button\" onclick='opBorrowModal(" + bicycle.bicnumber + ")'>借车</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                } else {
                    $("#displayBicycleError").html("没有该车！");
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });

    });

});

function getArea() {
    var siteArea = $("#checkSite:first").nextAll().find(":checked").text();
    $("#checkSite").html("<option disabled=\"disabled\" selected=\"selected\">选择一个区域</option>");
    $.ajax({
        url: "/Bicycle/GetArea.do",
        type: "POST",
        success: function (data) {
            var len = data.sites.length;
            for(var i = 0; i<len; i++) {
                var str = "<option>" + data.sites[i] + "</option>";
                $("#checkSite").append(str);
            }
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function pageTo(pageNum, siteArea) {
    $(".site-table tbody").html("");
    $(".page-site").html("");
    $.ajax({
        url: "/Bicycle/DisplaySite.do",
        type: "POST",
        dataType: "json",
        data: {siteArea: siteArea, pageNum: pageNum},
        success: function (data) {
            var sites = data.sites;
            var pageLen = data.pageLen;
            for(var i = 0; i<sites.length; i++) {
                $(".site-table tbody").append("<tr>\n" +
                    "                            <td>" + sites[i].sitenumber + "</td>\n" +
                    "                            <td>" + sites[i].sitearea + "</td>\n" +
                    "                            <td>" + sites[i].siteamount + "</td>\n" +
                    "                        </tr>");
            }
            $(".page-site").append("<li><a onclick='pageTo(1, " + "\"" + siteArea + "\"" + ")'>&laquo;</a></li>");
            for(var i = 1; i<=pageLen; i++) {
                if(i === pageNum) {
                    $(".page-site").append("<li class='active'><a onclick='pageTo(" + i + "," + "\"" + siteArea + "\"" + ")'>" + i + "</a></li>");
                } else {
                    $(".page-site").append("<li><a onclick='pageTo(" + i + "," + "\"" + siteArea + "\"" + ")'>" + i + "</a></li>");
                }
            }
            $(".page-site").append("<li><a onclick='pageTo(" + pageLen + "," + "\"" + siteArea + "\"" + ")'>&raquo;</a></li>");
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function showBicycle(siteId, pageNum, pageSize) {
    $(".bicycle-table tbody").html("");
    $("#displayBicycleError").html("");
    $(".page-bicycle").html("");
    $(".table-length").html("");
    $.ajax({
        url: "/Bicycle/DisplayBicycle.do",
        type: "POST",
        dataType: "json",
        data: {
            siteId: siteId,
            pageNum: pageNum,
            pageSize: pageSize
        },
        success: function (data) {
            if(data.message === "right") {
                for(var i = 0; i<data.bicycles.length; i++) {
                    var bicycle = data.bicycles[i];
                    $(".bicycle-table tbody").append("<tr>\n" +
                        "                        <td>" + bicycle.bicnumber +"</td>\n" +
                        "                        <td>" + bicycle.bictype + "</td>\n" +
                        "                        <td>" + bicycle.bicrentprice + "</td>\n" +
                        "                        <td>\n" +
                        "                            <button type=\"button\" class=\"button button-rounded button-royal button-small borrow-button\" onclick='opBorrowModal(" + bicycle.bicnumber+ ")'>借车</button>\n" +
                        "                        </td>\n" +
                        "                    </tr>");
                }
                // 分页
                $(".page-bicycle").append("<li><a onclick='changeClickBic(" + siteId + "," + pageNum + ",1" + ")'>&laquo;</a></li>");
                for(var i = 1; i<=data.pageLen; i++) {
                    if(i === pageNum) {
                        $(".page-bicycle").append("<li class='active' onclick='changeClickBic(" + siteId + "," + pageNum + "," + i + ")'><a>" + i + "</a></li>");
                    } else {
                        $(".page-bicycle").append("<li><a onclick='changeClickBic(" + siteId + "," + pageNum + "," + i + ")'>" + i + "</a></li>");
                    }
                }
                $(".page-bicycle").append("<li><a onclick='changeClickBic(" + siteId + "," + pageNum + "," + data.pageLen + ")'>&raquo;</a></li>");
                $(".table-length").append("<select class=\"form-control\" onchange='changePageSize(" + siteId + ")'>\n" +
                    "                    <option>3</option>\n" +
                    "                    <option>5</option>\n" +
                    "                    <option>10</option>\n" +
                    "                    <option>25</option>\n" +
                    "                </select>");
                $(".table-length select option").each(function () {
                    if($(this).text() == pageSize) {
                        $(this).attr("selected", "selected");
                        return;
                    }
                });
            } else {
                $("#displayBicycleError").html("该站点没有车！");
            }
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function changeClickBic(siteId, pageNow, pageNum) {
    if(pageNow === pageNum) {
        return;
    } else {
        showBicycle(siteId, pageNum, $(".table-length select").find(":checked").text());
    }
}

function changePageSize(siteId) {
    var pageSize = $(".table-length select").find(":checked").text();
    showBicycle(siteId, 1, pageSize);
}

function opBorrowModal(bicycleNumber) {
    $.ajax({
        url: "/Bicycle/JudgmentBorrow.do",
        type: "POST",
        dataType: "json",
        data: {bicycleNumber: bicycleNumber},
        success: function (data) {
            var meg = data.errorLog;
            if(meg === "null") {
                $(".borrow-message").html("<div class=\"alert alert-success\">\n" +
                    "                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">\n" +
                    "                    &times;\n" +
                    "                </a>\n" +
                    "                <strong>成功！</strong>租借成功。\n" +
                    "            </div>");
                //window.location.href = "/Bicycle/Borrow";
            } else if(meg === "money") {
                $(".borrow-message").html("<div class=\"alert alert-danger\">\n" +
                    "                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">\n" +
                    "                    &times;\n" +
                    "                </a>\n" +
                    "                <strong>错误！</strong>您的租借卡余额不足，请先充值。\n" +
                    "            </div>");
            } else if(meg === "card") {
                $(".borrow-message").html("<div class=\"alert alert-danger\">\n" +
                    "                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">\n" +
                    "                    &times;\n" +
                    "                </a>\n" +
                    "                <strong>错误！</strong>请先办理租借卡。\n" +
                    "            </div>");
            } else if(meg === "two") {
                $(".borrow-message").html("<div class=\"alert alert-danger\">\n" +
                    "                <a href=\"#\" class=\"close\" data-dismiss=\"alert\">\n" +
                    "                    &times;\n" +
                    "                </a>\n" +
                    "                <strong>错误！</strong>同一时间只能租用一辆自行车。\n" +
                    "            </div>");
            } else {
                window.location.href = "/Bicycle/Home";
            }
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}