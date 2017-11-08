$(document).ready(function () {

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
        height: 450
    });



});